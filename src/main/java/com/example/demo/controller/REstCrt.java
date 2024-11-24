package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.IItemMenu;
import com.example.demo.dao.IRestaurant;
import com.example.demo.model.ItemeMenu;
import com.example.demo.model.Restaurant;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin("*")
@RestController
@RequestMapping("/back")

public class REstCrt {
	
	
	@Autowired
	IRestaurant dao_rest;
	
	@Autowired
	IItemMenu dao_item;
	
	@GetMapping("/restaurants")
	public List<Restaurant> f1(){
		return dao_rest.findAll();
	}
	
	@GetMapping("/restaurant/{id}")
	public Restaurant f2(@PathVariable int id){
		return dao_rest.findById(id).get();
	}
	
	
	@PostMapping("/addRestaurant")
	public void f3(@RequestParam String rest, @RequestParam MultipartFile file) {
		try {
			if (!file.isEmpty()) {
				ObjectMapper obj = new ObjectMapper();
				Restaurant r = obj.readValue(rest, Restaurant.class);
				byte[] image = file.getBytes();
				dao_rest.save(new Restaurant(image, r.getTitre(), r.getDescription(), r.getAdresse(), r.getSpecialite()));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	@DeleteMapping("/deleteRestaurant/{id}")
	public void f4(@PathVariable int id){
		dao_rest.deleteById(id);
	}
	
	@GetMapping("/menu/restaurant/{id}")
	public List<ItemeMenu> f5(@PathVariable int id){
		return dao_item.findByRestId(id);
	}
	
	@GetMapping("/itemMenu/{id}")
	public ItemeMenu f5S(@PathVariable int id){
		return dao_item.findById(id).get();
	}
	
	
	@PostMapping("/addMenu")
	public void f6(@RequestBody ItemeMenu item){
		dao_item.save(item);
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public void f7(@PathVariable  int id){
		dao_item.deleteById(id);
	}
	
	
}