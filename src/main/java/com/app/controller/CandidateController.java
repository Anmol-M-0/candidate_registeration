package com.app.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.CandidateDTO;
import com.app.pojos.Candidate;
import com.app.service.CandidateService;

@Controller
@RequestMapping(value = "/candidate")
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	
	
	Logger logger = LoggerFactory.getLogger(CandidateController.class);
	@RequestMapping(value = "/register")
	public String fetchRegisterationPage(Model model) {
		logger.info("in candidate reg handler");
		model.addAttribute("cand",new CandidateDTO());
		
		
		
		return "/candidate/register";
		
	}
	
	@RequestMapping(value = "/confirm",method = RequestMethod.POST)
	public String confirmCandidateRegisteration(@ModelAttribute("cand") CandidateDTO cand, BindingResult result, HttpSession session, Model model ) {
		session.setAttribute("cand", cand);
		model.addAttribute(cand);
		return "/candidate/confirm";
	}
	
	@RequestMapping(value = "/confirm/save")
	public String saveCandidateInf(HttpSession session, RedirectAttributes flashMap, Model model) {
		CandidateDTO  cand = (CandidateDTO)session.getAttribute("cand");
		Candidate candidate = candidateService.saveCandidateInfo(cand);
		System.out.println("chking model cand : "+ model.getAttribute("cand"));
		session.removeAttribute("cand");
		flashMap.addFlashAttribute("entity", candidate);
		
		return "redirect:/admin/adminPage";
	}
}
