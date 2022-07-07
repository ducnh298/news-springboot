package com.javaspringbootweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaspringbootweb.dto.NewsDTO;

@Service
public interface INewsService {

	NewsDTO save(NewsDTO newsDTO);

	void delete(Long[] ids);

	List<NewsDTO> findAll(Pageable pageable);
	
	List<NewsDTO> findAll();

	int totalItem();
}
