package cultureMedia.service;

import java.util.List;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.model.View;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;

public class CultureMediaServiceImpl implements CultureMediaService {
	
	
	private VideoRepository videoRepository;
	private ViewsRepository viewsRepository;
	
	public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
		this.videoRepository = videoRepository;
		this.viewsRepository = viewsRepository;
	}
	@Override
	public List<Video> findAll() throws VideoNotFoundException {
		return videoRepository.findAll();
	}

	@Override
	public Video save(Video save) {
		Video videoAdd = videoRepository.save(save);
		return videoAdd;
	}

	@Override
	public View save(View save) {
		View viewAdd = viewsRepository.save(save);
		return viewAdd;
	}
	public List<Video> findByTitle(String title) throws VideoNotFoundException {
		return videoRepository.findByTitle(title);
	}
	public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
		return videoRepository.findByDuration(fromDuration, toDuration);
	}
	
}
