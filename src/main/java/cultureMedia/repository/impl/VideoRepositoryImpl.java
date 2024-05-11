package cultureMedia.repository.impl;
import java.util.ArrayList;
import java.util.List;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {

	private final List<Video> videos;

	public VideoRepositoryImpl() {
		videos = new ArrayList<>();
	}

	
	@Override
    public List<Video> findAll() throws VideoNotFoundException {
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No se encontraron videos");
        }
        return videos;
    }


	@Override
	public Video save(Video video) {
		this.videos.add( video );
		return video;
	}

	@Override
	
    public List<Video> find(String title) {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.title().toLowerCase().contains(title.toLowerCase())) {
                filteredVideos.add(video);
            }
        }
        
        if (filteredVideos.isEmpty()) {//Retorna array vacío si no hay videos
            return new ArrayList<>();
        }
        return filteredVideos;
    }

	@Override
	public List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException {
	    List<Video> filteredVideos = new ArrayList<>();
	    for (Video video : videos) {
	        if (video.duration() >= fromDuration && video.duration() <= toDuration) {
	            filteredVideos.add(video);
	        }
	    }
	    if (filteredVideos.isEmpty()) {
	    	return new ArrayList<>(); 
	    }
	    return filteredVideos;
	}
}
