package com.spring.henallux.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.model.User;
import com.spring.henallux.service.HobbiesService;


@Controller
@RequestMapping(value="/userInscription")
@SessionAttributes({InscriptionController.CURRENTUSER})
public class InscriptionController {

	protected static final String CURRENTUSER = "currentUser";
	
	//déclarer pour toute la durée de la session, et non pas du model car
	//sinon il n'est que sur la page et non pour la session
	@ModelAttribute(CURRENTUSER)
	public User user(){
		return new User();
	}
	
	@Autowired
	private HobbiesService hobbiesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getPageUserInscription(Model model)
	{
		//ici on l'ajoute au model pour y accèder plus tard
		//dans la page jsp
		model.addAttribute("hobbies",hobbiesService.getListHobbies());
		
		//On ne fait pas cette ligne car la durée du "model" n'est que la page
		//model.addAttribute("userInscription",new User());
		return "integrated:userInscription";
	}
	
	@RequestMapping(value="/send",method=RequestMethod.POST)
	public String getFormData(Model model,
							@Valid @ModelAttribute(value=CURRENTUSER) User userInscriptionInstance,
							final BindingResult errors)
	//On récupère les informations du formulaire via son modelAttribute et on lui dit de mettre les info dans une instance de type User
	//L'instance de User contient telle les informations du formulaire ?
	{
		if(errors.hasErrors())
		{
			System.out.println("Name : "+userInscriptionInstance.getName()+"\nAge : "+userInscriptionInstance.getAge()+"\nSexe : "+(userInscriptionInstance.getMale() ? "Male" : "Female")+"\nHobby : "+userInscriptionInstance.getHobby());
			//redirect vers un controller
			return "redirect:/userInscription";
		}
		else
		{
			return "redirect:/gift";
		}
	}
}
