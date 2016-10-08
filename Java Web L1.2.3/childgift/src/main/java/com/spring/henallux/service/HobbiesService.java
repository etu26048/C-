package com.spring.henallux.service;
import com.spring.henallux.model.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class HobbiesService {

	private ArrayList<Hobby> listHobbies;

	public HobbiesService() {
		listHobbies = new ArrayList<Hobby>();
		listHobbies.add(new Hobby("1","chant"));
		listHobbies.add(new Hobby("2","tambour"));
		listHobbies.add(new Hobby("3","flûte de pan"));
		listHobbies.add(new Hobby("4","Cornemuse"));
	}

	public ArrayList<Hobby> getListHobbies() {
		return listHobbies;
	}

	public void setListHobbies(ArrayList<Hobby> listHobbies) {
		this.listHobbies = listHobbies;
	}
}
