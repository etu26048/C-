package com.spring.henallux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.model.User;
import com.spring.henallux.service.GiftService;

@Controller
@RequestMapping(value="/gift")
@SessionAttributes({"currentUser"})
public class GiftController{
	
	@Autowired
	private GiftService giftService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model,
						@ModelAttribute(value="currentUser") User user)
	{
		String cadeau = giftService.chooseGift(user.getHobby(), user.getAge());
		model.addAttribute("gift",cadeau);
		model.addAttribute("name",user.getName());
		model.addAttribute("hobby",user.getHobby());
		return "integrated:gift";
	}

	
}
