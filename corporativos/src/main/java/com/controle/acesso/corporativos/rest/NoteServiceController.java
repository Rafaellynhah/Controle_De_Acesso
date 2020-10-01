package com.controle.acesso.corporativos.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controle.acesso.corporativos.model.AccessTokenMapper;

@RestController
public class NoteServiceController {

	
	@PreAuthorize("hasRole('CREATE')")
	@RequestMapping(value="/time", method=RequestMethod.POST)
	public String createTime() {
		
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper)
				((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		
		System.out.println("ID:"+accessTokenMapper.getId());
		System.out.println("Name:"+accessTokenMapper.getName());
		System.out.println("Email ID:"+accessTokenMapper.getUserName());
		
		return "Time has been created successfully";
	}
	
	@PreAuthorize("hasRole('EDIT')")
	@RequestMapping(value="/time", method=RequestMethod.PUT)
	public String updateTime() {
		return "Time has been updated successfully";
	}
	
	@PreAuthorize("hasRole('DELETE')")
	@RequestMapping(value="/time", method=RequestMethod.DELETE)
	public String deleteTime() {
		return "Time has been deleted successfully";
	}
	
	@PreAuthorize("hasRole('VIEW_ALL')")
	@RequestMapping(value="/time", method=RequestMethod.GET)
	public String viewAllTimes() {
		return "Times ALL API response";
	}
	
	@PreAuthorize("hasRole('VIEW')")
	@RequestMapping(value="/timeById", method=RequestMethod.GET)
	public String viewTimesByID() {
		return "Times By ID response";
	}
	
	
	
	
}
