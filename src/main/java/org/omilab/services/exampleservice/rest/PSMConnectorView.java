package org.omilab.services.exampleservice.rest;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.omilab.services.exampleservice.model.*;
import org.omilab.services.exampleservice.repo.ForumPostingRepository;
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
	private final ForumPostingRepository forumPostingRepository;

	private final InstanceMgmtService instanceMgmtService;
	private final PageBuilder pageBuilder = new PageBuilder();

	@Autowired
	public PSMConnectorView(ForumUserRepository forumUserRepository,
							ForumThreadRepository forumThreadRepository,
							ForumPostingRepository forumPostingRepository,
							InstanceMgmtService instanceMgmtService) {
		//this.pageRepo = pageRepo;

		this.forumUserRepository = forumUserRepository;
		this.instanceMgmtService = instanceMgmtService;
		this.forumThreadRepository = forumThreadRepository;
		this.forumPostingRepository = forumPostingRepository;

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
		ForumPosting forumPosting = new ForumPosting();
	//	System.out.println(servletRequest.getRemoteAddr());

	//	if(!instanceMgmtService.checkAccess(servletRequest.getRemoteAddr(), instanceid))
	//		return new GenericServiceContent("Not allowed!");


		final StringBuilder sb = new StringBuilder();
		System.out.println(request.getParams().get("navinput"));




        if(request.getParams().get("login") !=null &&  !request.getParams().get("navinput").equalsIgnoreCase("logout")){
        	forumUser = forumUserRepository.findByUserId(Integer.parseInt(request.getParams().get("login")));
        	sb.append(pageBuilder.loggedInNav(forumUser));



        	if(request.getParams().get("navinput").contains("thread")){
        		String thread = request.getParams().get("navinput");
        		String forumThreadIdNew = thread.substring(6);
        		Integer forumThreadId = Integer.parseInt(forumThreadIdNew);
        		forumThread = forumThreadRepository.findByThreadId(forumThreadId);
				if(request.getParams().get("answer") != null){
					forumPosting.setForumThread(forumThread);
					forumPosting.setPostingContent(request.getParams().get("answer"));
					forumPosting.setForumUser(forumUser);
					forumPostingRepository.save(forumPosting);
					forumThread.addForumPosting(forumPosting);

					//		forumThreadRepository.findByThreadId(answerThreadId).addForumPosting();
				}
        		sb.append("<div class=\"postings\">");
        		for(int i = 0; i<forumThread.getForumPostings().size(); i++) {
					sb.append(pageBuilder.showThread(forumThread, i));
				}
				sb.append("</div>");
				sb.append("  <form method=\"post\" action=\"\">\n" +
						"    <div class=\"form-group\">\n" +
						"      <label for=\"answer\">Create new Answer:</label>" +
						"      <textarea class=\"form-control\" rows=\"5\" id=\"answerid\" name=\"answer\"></textarea>" +
						"    </div>\n" +
						"   <input type=\"hidden\" name=\"login\" value=\"" + forumUser.getUserId() + "\" />" +
						"   <input type=\"hidden\" name=\"user\" value=\""+ forumUser.getUserName() + "\" />" +
						"<input type=\"hidden\" id=\"navform2\" name=\"navinput\" value=\"thread"+forumThreadId + "\" />" +
						"    <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
						"  </form>");
			}

			else if(request.getParams().get("navinput").equalsIgnoreCase("newtopic")){
				sb.append("<div class=\"container\"");
				sb.append(pageBuilder.createThread(forumUser));
			}

			if(request.getParams().get("threadtitle") != null){

				forumThread.setThreadTitle(request.getParams().get("threadtitle"));
				forumUser = forumUserRepository.findByUserName(request.getParams().get("user"));
				forumThread.setForumUser(forumUser);
				forumThread.setThreadTitle(request.getParams().get("threadtitle"));
				forumThreadRepository.save(forumThread);
				forumPosting.setForumThread(forumThread);
				forumPosting.setPostingContent(request.getParams().get("threadposting"));
				forumPosting.setForumUser(forumUser);
				forumPostingRepository.save(forumPosting);
				forumThread.addForumPosting(forumPosting);
				sb.append(pageBuilder.showThread(forumThread, 0));
			}

        	if(request.getParams().get("navinput").equalsIgnoreCase("forum")){
				sb.append("<div class=\"list-group\">");
				for(ForumThread f : forumThreadRepository.findAll()){
					sb.append(pageBuilder.showForum(f));
				}
				sb.append("</div>");


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
                    sb.append(pageBuilder.loggedInNav(forumUser));
                }else{
                    sb.append(pageBuilder.notLoggedInNav());
                }
            }else {
				sb.append(pageBuilder.notLoggedInNav());
				if(request.getParams().get("navinput")!=null) {
					if (request.getParams().get("navinput").equalsIgnoreCase("register")) {
						sb.append(pageBuilder.showRegistration());
					}
				}
            }
        }
        sb.append("</div>");
		return new GenericServiceContent(sb.toString());

	}
}