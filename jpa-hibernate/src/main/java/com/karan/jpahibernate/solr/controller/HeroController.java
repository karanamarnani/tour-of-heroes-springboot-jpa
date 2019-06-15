package com.karan.jpahibernate.solr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.karan.jpahibernate.solr.service.HeroService;

@Controller
@Component
@Scope("prototype")
public class HeroController {

	@Autowired
	private HeroService heroService;

	@GetMapping("/search/hero/{id}")
	public String search(Model model, @PathVariable("id") String id, HttpServletRequest request) {
		model.addAttribute("hero", heroService.findById(id));
		return "hero";
	}
}
