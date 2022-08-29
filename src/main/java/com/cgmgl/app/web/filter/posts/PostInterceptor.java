package com.cgmgl.app.web.filter.posts;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cgmgl.app.bl.dto.PostDto;
import com.cgmgl.app.bl.dto.auth.AuthUser;
import com.cgmgl.app.bl.service.PostService;
import com.cgmgl.app.bl.service.auth.MyAuthenticationService;

public class PostInterceptor implements HandlerInterceptor {

	@Autowired
	PostService postService;
	
	@Autowired
	MyAuthenticationService myAuthenticationService;
	
	Long id;

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map<String, String> path_urls = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		System.out.println(path_urls);
		
		
		if (path_urls.isEmpty())
			return true;			
		
		try {
			id = Long.parseLong(path_urls.get("id"));	
		}catch (Exception e) {
			System.out.println("here");
			response.sendRedirect(request.getContextPath() + "/denied");
			return true;
		}
		
		PostDto postDto = postService.getPostById(id);
		AuthUser authUser = myAuthenticationService.getPrincipal();
		
		if(!postDto.isIs_published())
			response.sendRedirect(request.getContextPath() + "/denied");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
