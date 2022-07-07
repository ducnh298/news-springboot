package com.javaspringbootweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringbootweb.api.output.NewsOutput;
import com.javaspringbootweb.dto.NewsDTO;
import com.javaspringbootweb.service.INewsService;

@RestController
public class NewsAPI {

	@Autowired
	private INewsService newsService;

	@GetMapping(value = "/news")
	public NewsOutput showNews(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		NewsOutput result = new NewsOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setNews(newsService.findAll(pageable));
			result.settotalPage((int) Math.ceil(newsService.totalItem() / limit));
		} else {
			result.setNews(newsService.findAll());
		}
		return result;
	}

	@PostMapping(value = "/news")
	public NewsDTO createNews(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}

	@PutMapping(value = "/news/{id}")
	public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newsService.save(model);
	}

	@DeleteMapping(value = "/news")
	public void deleteNews(@RequestBody Long[] ids) {
		newsService.delete(ids);

	}

}
