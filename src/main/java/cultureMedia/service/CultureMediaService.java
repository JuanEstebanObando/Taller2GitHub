package cultureMedia.service;
import java.util.List;

import cultureMedia.model.Video;
import cultureMedia.model.View;
public interface CultureMediaService {

	
	List<Video> findAll();
	Video save(Video save);
	View save(View save);
}
