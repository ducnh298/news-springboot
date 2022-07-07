package com.javaspringbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringbootweb.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
