package cultureMedia.controllers;

import java.util.*;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.service.CultureMediaService;

public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController(CultureMediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}


	public List<Video> find_allVideos() throws VideoNotFoundException {
		return cultureMediaService.findAll();
	}


}
