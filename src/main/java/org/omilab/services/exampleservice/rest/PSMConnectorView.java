package org.omilab.services.exampleservice.rest;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.omilab.services.exampleservice.model.ForumUser;
import org.omilab.services.exampleservice.model.GenericRequest;
import org.omilab.services.exampleservice.model.GenericServiceContent;
import org.omilab.services.exampleservice.model.PageBuilder;
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
	private final InstanceMgmtService instanceMgmtService;
	private final PageBuilder pageBuilder = new PageBuilder();

	@Autowired
	public PSMConnectorView(ForumUserRepository forumUserRepository, InstanceMgmtService instanceMgmtService) {
		//this.pageRepo = pageRepo;
		this.forumUserRepository = forumUserRepository;
		this.instanceMgmtService = instanceMgmtService;

	}
//randombs
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

		if(!instanceMgmtService.checkAccess(servletRequest.getRemoteAddr(), instanceid))
			return new GenericServiceContent("Not allowed!");


		final StringBuilder sb = new StringBuilder();
		System.out.println(request.getParams().get("navinput"));

        if(request.getParams().get("login") !=null){
        	sb.append(pageBuilder.loggdInNav("hahaha"));
        }else {
            if(request.getParams().get("user")!=null && request.getParams().get("password")!=null){

                forumUser = forumUserRepository.
                        findByUserNameAndUserPassword(
                                request.getParams().get("user"),
                                request.getParams().get("password")
                        );
                if(forumUser != null) {
                    sb.append(pageBuilder.loggdInNav(request.getParams().get("user")));
                }else{
                    sb.append(pageBuilder.notLoggedInNav());
                }
            }else {
                sb.append(pageBuilder.notLoggedInNav());
            }
        }
		return new GenericServiceContent(sb.toString());

	}
}