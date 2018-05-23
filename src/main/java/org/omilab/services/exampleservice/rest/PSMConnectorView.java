package org.omilab.services.exampleservice.rest;

import org.omilab.services.exampleservice.model.GenericRequest;
import org.omilab.services.exampleservice.model.GenericServiceContent;
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

	private final PageRepository pageRepo;

	private final InstanceMgmtService instanceMgmtService;

	@Autowired
	public PSMConnectorView(PageRepository pageRepo, InstanceMgmtService instanceMgmtService) {
		this.pageRepo = pageRepo;
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

		servletRequest.getSession().getAttribute("content").toString();
		request.getParams().get("content");
		if(!instanceMgmtService.checkAccess(servletRequest.getRemoteAddr(), instanceid))
			return new GenericServiceContent("Not allowed!");



		final StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"panel panel-default\"><div class=\"panel-body\">");
		if(request.getParams().get("content") !=null){
			sb.append(request.getParams().get("content"));
		}
		//sb.append(pageRepo.findByInstanceAndEndpoint(instanceid,endpoint).getContent());
		sb.append("<form method=\"POST\" action=\"\">\n" + " Enter something " +
		" :<br>\n" + "<input type=\"text\" name=\"content\">\n" + "<input type=\"submit\">\n" +
		"</form>");
		sb.append("</div></div>");


		return new GenericServiceContent(sb.toString());
	}



}