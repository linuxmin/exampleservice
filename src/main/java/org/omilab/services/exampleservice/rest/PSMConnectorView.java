package org.omilab.services.exampleservice.rest;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.omilab.services.exampleservice.model.*;
import org.omilab.services.exampleservice.repo.ForumThreadRepository;
import org.omilab.services.exampleservice.repo.ForumUserRepository;
import org.omilab.services.exampleservice.repo.PageRepository;
import org.omilab.services.exampleservice.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/view")
public final class PSMConnectorView {

//	private final PageRepository pageRepo;

	private final ForumUserRepository forumUserRepository;
	private final ForumThreadRepository forumThreadRepository;

	private final InstanceMgmtService instanceMgmtService;
	private final PageBuilder pageBuilder = new PageBuilder();

	@Autowired
	public PSMConnectorView(ForumUserRepository forumUserRepository,
							ForumThreadRepository forumThreadRepository,
							InstanceMgmtService instanceMgmtService) {
		//this.pageRepo = pageRepo;
		this.forumUserRepository = forumUserRepository;
		this.instanceMgmtService = instanceMgmtService;
		this.forumThreadRepository = forumThreadRepository;

	}
	@POST
	@Path("/{instanceid}/{endpoint}")
	@Produces("application/json")
	@Consumes("application/json")
	public GenericServiceContent processRequest(final @PathParam("instanceid") Long instanceid,
												final @PathParam("endpoint") String endpoint,
												final @Context HttpServletRequest servletRequest,
												final GenericRequest request)
	{
		ForumUser forumUser = new ForumUser();
		ForumThread forumThread = new ForumThread();

		if(!instanceMgmtService.checkAccess(servletRequest.getRemoteAddr(), instanceid))
			return new GenericServiceContent("Not allowed!");


		final StringBuilder sb = new StringBuilder();
		System.out.println(request.getParams().get("navinput"));



        if(request.getParams().get("login") !=null && !request.getParams().get("navinput").equalsIgnoreCase("logout")){
        	sb.append(pageBuilder.loggedInNav("hahaha"));

			if(request.getParams().get("threadtitle") != null){
				sb.append("<div class=\"container\"");
				forumThread.setThreadTitle(request.getParams().get("threadtitle"));
				forumUser = forumUserRepository.findByUserName(request.getParams().get("user"));
				forumThread.setForumUser(forumUser);
				forumThread.setThreadTitle(request.getParams().get("threadtitle"));
				forumThreadRepository.save(forumThread);
				sb.append(pageBuilder.showThread(request.getParams().get("threadtitle"),request.getParams().get("threadposting")));
			}

        	if(request.getParams().get("navinput").equalsIgnoreCase("forum")){
        		sb.append(pageBuilder.createThread("Benjamin"));
			}
        	//sb.append(pageBuilder.homeSite());
        }else {
            if(request.getParams().get("user")!=null && request.getParams().get("password")!=null){

                forumUser = forumUserRepository.
                        findByUserNameAndUserPassword(
                                request.getParams().get("user"),
                                request.getParams().get("password")
                        );
                if(forumUser != null) {
                    sb.append(pageBuilder.loggedInNav(request.getParams().get("user")));
                }else{
                    sb.append(pageBuilder.notLoggedInNav());
                }
            }else {
				sb.append(pageBuilder.notLoggedInNav());

            }
        }
        sb.append("</div>");
		return new GenericServiceContent(sb.toString());

	}
}