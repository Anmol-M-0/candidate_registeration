package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.PartyDTO;
import com.app.pojos.Party;
import com.app.service.PartyService;

@Controller
@RequestMapping(value = "/party")
public class PartyController {
	
	@Autowired	
	private PartyService partyService;
	
	@RequestMapping(value = "/register")
	public String fetchPartyRegPage(Model model) {
		System.out.println("in party reg page");
		model.addAttribute(new PartyDTO());
		return "/party/register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerParty(Model model, @ModelAttribute("PartyDTO") PartyDTO partyDTO, HttpSession session) {
		System.out.println("in registerParty"+getClass().getName());
		System.out.println(partyDTO);
//		Party party = partyService.saveParty(partyDTO);
		model.addAttribute("party",partyDTO);
		session.setAttribute("partyDTO", partyDTO);
		return "/party/confirm";
	}
	@RequestMapping(value="/save")
	public String savePartyInfo(HttpSession session, RedirectAttributes flashMap) {
		
		System.out.println("in save party Info");
		PartyDTO dto = (PartyDTO)session.getAttribute("partyDTO");
		Party party = partyService.saveParty(dto);
		flashMap.addAttribute("entity", party);
		return "redirect:/admin/adminPage";
	}
	
	@RequestMapping(value = "/partyDetails/{id}", method = RequestMethod.POST)
	public String fetchPartyInfo(@PathVariable("id") Long id, Model model) {
		Party party = partyService.findById(id);
		model.addAttribute("party", party);
		return "/party/partyDetails";
	}
}
