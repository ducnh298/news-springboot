package com.javaspringbootweb.converter;

import org.springframework.stereotype.Component;

import com.javaspringbootweb.dto.NewsDTO;
import com.javaspringbootweb.entity.NewsEntity;

@Component
public class NewsConverter {

	public NewsEntity toEntity(NewsDTO dto) {
		NewsEntity entity = new NewsEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDes(dto.getShortDes());
		entity.setThumbnail(dto.getThumbnail());

		return entity;
	}

	public NewsDTO toDTO(NewsEntity entity) {
		NewsDTO dto = new NewsDTO();
		if (entity.getId() != null)
			dto.setId(entity.getId());

		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShortDes(entity.getShortDes());
		dto.setThumbnail(entity.getThumbnail());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());

		return dto;
	}

	// OverLoading
	public NewsEntity toEntity(NewsDTO dto, NewsEntity entity) {

		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDes(dto.getShortDes());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
}
