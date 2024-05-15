package cultureMedia.controllers;

import java.util.*;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.repository.impl.VideoRepositoryImpl;
import cultureMedia.repository.impl.ViewsRepositoryImpl;
import cultureMedia.service.CultureMediaService;
import cultureMedia.service.CultureMediaServiceImpl;

import org.springframework.web.bind.annotation.*;
@RestController
public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController(CultureMediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}
	
	public CultureMediaController() {this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(),new ViewsRepositoryImpl());}

	@GetMapping("/videos")
	public List<Video> findAll() throws VideoNotFoundException {
		return cultureMediaService.findAll();
	}

	@PostMapping("/videos")
    public Video agregar(@RequestBody Video video) {
        return cultureMediaService.save(video);
    }
}
