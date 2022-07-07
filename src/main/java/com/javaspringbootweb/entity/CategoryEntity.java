package com.javaspringbootweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
	@Column
	private String code;

	@Column
	private String name;

	@OneToMany(mappedBy = "category")
	private List<NewsEntity> newsList = new ArrayList();

	public CategoryEntity() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NewsEntity> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsEntity> newsList) {
		this.newsList = newsList;
	}

}