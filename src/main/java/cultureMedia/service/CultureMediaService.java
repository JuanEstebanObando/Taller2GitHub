package cultureMedia.service;
import java.util.List;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.model.View;
public interface CultureMediaService {

	
	List<Video> findAll() throws VideoNotFoundException;
	Video save(Video save);
	View save(View save);
	List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;

}
