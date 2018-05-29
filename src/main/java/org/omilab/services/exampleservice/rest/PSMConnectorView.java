package org.omilab.services.exampleservice.rest;

import org.omilab.services.exampleservice.model.*;
import org.omilab.services.exampleservice.service.ForumService;
import org.omilab.services.exampleservice.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;


@Component
@Path("/view")
public final class PSMConnectorView {

	private final InstanceMgmtService instanceMgmtService;
	private final ForumService forumService;

	private final PageBuilder pageBuilder = new PageBuilder();

	@Autowired
	public PSMConnectorView(ForumService forumService, InstanceMgmtService instanceMgmtService) {
	this.forumService = forumService;
	this.instanceMgmtService = instanceMgmtService;

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

		System.out.println(request.getParams().get("navinput"));
		ForumUser forumUser = new ForumUser();
		ForumThread forumThread = new ForumThread();
		ForumPosting forumPosting = new ForumPosting();
		final StringBuilder sb = new StringBuilder();

        if(request.getParams().get("login") !=null &&  !request.getParams().get("navinput").equalsIgnoreCase("logout")){
			forumUser = forumService.findUser(Integer.parseInt(request.getParams().get("login")));
			sb.append(pageBuilder.loggedInNav(forumUser));
			if(request.getParams().get("navinput").equalsIgnoreCase("home")){
				sb.append(pageBuilder.homeSite());
			}

        	if(request.getParams().get("deleteposting")!=null){
				forumService.deletePosting(Integer.parseInt(request.getParams().get("deleteposting")));
        	}

			if(request.getParams().get("navinput").equalsIgnoreCase("searching") && request.getParams().get("search")!=null){
				List<ForumThread> forumThreadsSearch = forumService.searchThread(request.getParams().get("search"));
				if(forumThreadsSearch.size() > 0){
					sb.append("<div class=\"list-group\">");
					for(ForumThread f :forumThreadsSearch){
						sb.append(pageBuilder.showForum(f));
					}
					sb.append("</div>");
				}
			}

        	if(request.getParams().get("navinput").equalsIgnoreCase("profile")){
				List<ForumPosting> forumPostings = forumService.findUserPostings(forumUser.getUserId());
				sb.append(pageBuilder.showProfile(forumUser, forumPostings));
			}

        	if(request.getParams().get("navinput").contains("thread")){
        		String thread = request.getParams().get("navinput");
        		String forumThreadIdNew = thread.substring(6);
        		Integer forumThreadId = Integer.parseInt(forumThreadIdNew);
        		forumThread = forumService.findThread(forumThreadId);
				if(request.getParams().get("answer") != null){
					forumPosting.setForumThread(forumThread);
					forumPosting.setPostingContent(request.getParams().get("answer"));
					forumPosting.setForumUser(forumUser);
					forumService.savePosting(forumPosting);
					forumThread.addForumPosting(forumPosting);

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
				forumUser = forumService.findUserByUserName(request.getParams().get("user"));
				forumThread.setForumUser(forumUser);
				forumThread.setThreadTitle(request.getParams().get("threadtitle"));
				forumService.saveThread(forumThread);
				forumPosting.setForumThread(forumThread);
				forumPosting.setPostingContent(request.getParams().get("threadposting"));
				forumPosting.setForumUser(forumUser);
				forumService.savePosting(forumPosting);
				forumThread.addForumPosting(forumPosting);
				sb.append(pageBuilder.showThread(forumThread, 0));
			}

        	if(request.getParams().get("navinput").equalsIgnoreCase("forum")){
				sb.append("<div class=\"list-group\">");
				for(ForumThread f : forumService.findAllThreads()){
					sb.append(pageBuilder.showForum(f));
				}
				sb.append("</div>");


			}
        }else {
            if(request.getParams().get("user")!=null && request.getParams().get("password")!=null){

                forumUser = forumService.
                        findUserByUserNameAndUserPassword(
                                request.getParams().get("user"),
                                request.getParams().get("password")
                        );
                if(forumUser != null) {
                    sb.append(pageBuilder.loggedInNav(forumUser));
                }else{
                    sb.append(pageBuilder.notLoggedInNav());
					sb.append(pageBuilder.homeSite());
                }
            }else {
				sb.append(pageBuilder.notLoggedInNav());
				if(request.getParams().get("nav")!=null)
					if(request.getParams().get("nav").equalsIgnoreCase("home")) {
						sb.append(pageBuilder.homeSite());
					}


				if(request.getParams().get("nav")!=null) {
					if (request.getParams().get("nav").equalsIgnoreCase("register")) {
						if(request.getParams().get("username")!=null && request.getParams().get("pwd")!=null && request.getParams().get("rpwd")!=null && request.getParams().get("email")!=null ){
							if(request.getParams().get("pwd").equals(request.getParams().get("rpwd"))){

								forumUser.setUserData(request.getParams().get("username"),
										request.getParams().get("pwd"),
										request.getParams().get("email"));
								try {
									forumService.saveUser(forumUser);
									sb.append("<div><h1>Thank you! You can login now!</h1></div>");
								}catch(Exception e){
									sb.append("<div><h1>Username already existent, try again!</h1></div>");
									sb.append(pageBuilder.showRegistration());

								}

							}else {
								sb.append("<div><h1>Passwords didn't match, try again!</h1></div>");
								sb.append(pageBuilder.showRegistration());
							}
						}else {
							sb.append(pageBuilder.showRegistration());
						}
					}
				}
            }
        }
        sb.append("</div>");
		return new GenericServiceContent(sb.toString());

	}
}