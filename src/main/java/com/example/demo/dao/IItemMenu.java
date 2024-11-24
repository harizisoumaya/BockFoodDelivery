package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ItemeMenu;

public interface IItemMenu extends JpaRepository<ItemeMenu, Integer> {

    // Trouver les items par l'ID du restaurant
	public List<ItemeMenu> findByRestId(int id);}
