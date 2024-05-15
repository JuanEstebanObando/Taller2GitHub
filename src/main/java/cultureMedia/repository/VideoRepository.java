package cultureMedia.repository;

import java.util.List;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;

public interface VideoRepository {
	List<Video> findAll() throws VideoNotFoundException;
	Video save(Video save);
	List<Video> find(String title);
	List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException;
	List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
	List<Video> findByTitle(String title) throws VideoNotFoundException;
}
