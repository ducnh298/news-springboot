package com.javaspringbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringbootweb.entity.NewsEntity;


public interface NewsRepository extends JpaRepository<NewsEntity, Long >{
	
}
