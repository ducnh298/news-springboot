package com.javaspringbootweb.api.output;

import java.util.ArrayList;
import java.util.List;

import com.javaspringbootweb.dto.NewsDTO;

public class NewsOutput {
	private int page;
	private int totalPage;
	private List<NewsDTO> news = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int gettotalPage() {
		return totalPage;
	}

	public void settotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<NewsDTO> getNews() {
		return news;
	}

	public void setNews(List<NewsDTO> news) {
		this.news = news;
	}
}
