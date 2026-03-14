package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;

@Controller
public class RestaurantListController {

	/*--- 最初のリクエスト -------------------------*/
	@GetMapping("/top")
	private String restaurantList(
			@ModelAttribute RestaurantSearchForm form) {
		return "restaurant-list";
	}
	
	/*--- 検索リクエスト -------------------------*/
	@PostMapping("/restaurant-search")
	private String restaurantSearch(
			@ModelAttribute RestaurantSearchForm form,
			Model model) {

		//--テストデータ--
		List<Restaurant> list = new ArrayList<Restaurant>();
		list.add(new Restaurant(1, "店舗１", "キャッチ１", 3.5));
		list.add(new Restaurant(2, "店舗２", "キャッチ２", 0.0));
		list.add(new Restaurant(3, "店舗３", "キャッチ３", 4.4444));
		//--テストデータ--
		
		model.addAttribute("restaurantList", list);
		
		return "restaurant-list";
	}
	
}
