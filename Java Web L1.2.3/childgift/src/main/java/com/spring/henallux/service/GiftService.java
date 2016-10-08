package com.spring.henallux.service;

import org.springframework.stereotype.Service;

@Service
public class GiftService {

	
	public String chooseGift(String hobby,int age){
		
		if(age < 5)
		{
			return "puzzle";
		}
		else
		{
			if(age < 10)
			{
				return "DVD";
			}
			else
			{
				return "livre";
			}
		}
	}
}
