package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;

public interface CateRepository extends JpaRepository<Category, Integer> {

}
