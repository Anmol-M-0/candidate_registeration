package com.app.controller;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HomePageController {
	private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

	public HomePageController() {
	}
/*"X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"*/
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String fetchHomePage(Locale locale,Model model, @RequestHeader HttpHeaders headers) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println(locale.toString());
		logger.info("welcome home! testing headers : {}", headers);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "/home";// /WEB-INF/views/index.jsp
	}

}
