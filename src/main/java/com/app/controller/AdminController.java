package com.app.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.UserRepository;
import com.app.dto.LoginDTO;
import com.app.dto.SignUpDTO;
import com.app.pojos.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
	public AdminController() {
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String fetchLoginPage(Model model) {
		logger.info("in fetchLoginPage");
		model.addAttribute(new LoginDTO());
		return "/admin/login";
	}
	/*@ModelAttribute(name = "loginDTO")
	public LoginDTO getLoginDTO() {
		
		logger.info("added loginDTO to the model, path : {}",path);
		return new LoginDTO();
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLogin(@ModelAttribute(name = "loginDTO") LoginDTO loginDTO, BindingResult res, HttpSession session) {
		logger.info("in validateLogin");
		System.out.println(res);
		logger.info(res.getAllErrors().stream().map((err)->err.toString()).reduce((s, r)->s+", "+r).orElseGet(()->res.toString()));
		logger.info("email = {} and password = {}", loginDTO.getEmail(), loginDTO.getPassword());
		User user = userService.validateLogin(loginDTO.getEmail(), loginDTO.getPassword());
		logger.info("ID = {}, Email = {}, name = {}, pass = {}, phno = {}", user.getId(), user.getEmail(), user.getName().getFullName(), user.getPassword(), user.getPhoneNumber());
		session.setAttribute("admin", user);
		return "redirect:/admin/adminPage";
	}
	
	@RequestMapping(value="/adminPage")
	public String fetchAdminPage() {
		System.out.println("in fetch admin page");
		return "/admin/adminPage";
	}
	
	
	@RequestMapping(value = "/logout")
	public String logoutUser(HttpSession session, Model modelMap, HttpServletRequest request,
			HttpServletResponse resp) {
		System.out.println("in userLogout " + getClass().getName());
		System.out.println("in user logout ");
		// get user details from session scope n add them under model attr map
		modelMap.addAttribute("details", session.getAttribute("admin"));
		// invalidate session
		session.invalidate();
		// set refresh header to navigate the clnt to home page(index.jsp) after some
		// delay
		resp.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/admin/logout";// Actual view name : /WEB-INF/views/user/logout.jsp
	}
	
	
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public String fetchSignUpPage(Model model) {
		logger.info("in fetchSignUpPage");
		model.addAttribute(new SignUpDTO());
		return "/admin/signUp";
	}
/*	@ModelAttribute("signUpDTO")
	public SignUpDTO getSignUpDTO(){
		logger.info("in getSignUpDTO");
		return new SignUpDTO();
	}
	*/
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpUser(@ModelAttribute("signUpDTO") SignUpDTO signUpDTO, Model model, HttpSession session) {
		logger.info("in signUpUser");
		session.setAttribute("dto",signUpDTO);
		
		return "/admin/confirm";
		
	}
//	@RequestMapping(value= "/confirm")
//	public String confirmData() {
//		logger.info("in confirmData");
//		return "/admin/confirm";
//	}
//	
	@RequestMapping(value = "/save")
	public String saveUser(Model model, HttpSession session) {
		System.out.println("in save controller");
		SignUpDTO dto = (SignUpDTO)session.getAttribute("dto");
		System.out.println(dto);
		logger.info("print : "+session.getAttribute("dto"));
//		logger.info("print "+model.getAttribute("signUpDTO"));//model map gets reloaded for every session
		userService.addUser(dto);
		session.invalidate();
		return "redirect:/admin/login";
	}
	

}
