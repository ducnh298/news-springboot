package com.javaspringbootweb.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaspringbootweb.converter.NewsConverter;
import com.javaspringbootweb.dto.NewsDTO;
import com.javaspringbootweb.entity.CategoryEntity;
import com.javaspringbootweb.entity.NewsEntity;
import com.javaspringbootweb.repository.CategoryRepository;
import com.javaspringbootweb.repository.NewsRepository;
import com.javaspringbootweb.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewsConverter newsConverter;

	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		NewsEntity newsEntity = new NewsEntity();

		if (newsDTO.getId() != null) {
			NewsEntity oldNews = newsRepository.findOne(newsDTO.getId());
			newsEntity = newsConverter.toEntity(newsDTO, oldNews);
		} else
			newsEntity = newsConverter.toEntity(newsDTO);

		CategoryEntity category = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		newsEntity.setCategory(category);
		newsEntity = newsRepository.save(newsEntity);
		return newsConverter.toDTO(newsEntity);
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		for (Long item : ids)
			newsRepository.delete(item);
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> result = new ArrayList<NewsDTO>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		for (NewsEntity item : entities)
			result.add(newsConverter.toDTO(item));

		return result;
	}

	@Override
	public int totalItem() {
		return (int) newsRepository.count();
	}

	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> result = new ArrayList<NewsDTO>();
		List<NewsEntity> entities = newsRepository.findAll();
		for (NewsEntity item : entities)
			result.add(newsConverter.toDTO(item));

		return result;
	}

//	@Override
//	public NewsDTO update(NewsDTO newsDTO) {
//		NewsEntity oldNews = newsRepository.findOne(newsDTO.getId());
//		NewsEntity newsEntity = newsConverter.toEntity(newsDTO,oldNews);
//		
//		CategoryEntity category = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
//		newsEntity.setCategory(category);
//		newsEntity = newsRepository.save(newsEntity);
//		return newsConverter.toDTO(newsEntity);
//	}
}
