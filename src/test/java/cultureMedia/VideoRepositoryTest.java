package cultureMedia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.service.CultureMediaService;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VideoRepositoryTest {

    @Mock
    private CultureMediaService cultureMediaService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void mockFindAll() throws VideoNotFoundException {
        List<Video> expectedVideos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4));
        when(cultureMediaService.findAll()).thenReturn(expectedVideos);

        List<Video> actualVideos = cultureMediaService.findAll();

        assertEquals(expectedVideos, actualVideos);
    }

    @Test
    void mockFindByTitle() throws VideoNotFoundException {
        String title = "Clic";
        List<Video> expectedVideos = List.of(
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));
        when(cultureMediaService.findByTitle(title)).thenReturn(expectedVideos);

        List<Video> actualVideos = cultureMediaService.findByTitle(title);

        assertEquals(expectedVideos, actualVideos);
    }

    @Test
    void mockFindByDuration() throws VideoNotFoundException {
        double fromDuration = 4.0;
        double toDuration = 6.0;
        List<Video> expectedVideos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));
        when(cultureMediaService.findByDuration(fromDuration, toDuration)).thenReturn(expectedVideos);

        List<Video> actualVideos = cultureMediaService.findByDuration(fromDuration, toDuration);

        assertEquals(expectedVideos, actualVideos);
    }

    @Test
    void mockEmptyFind() throws VideoNotFoundException {
        when(cultureMediaService.findByTitle("titulo_que_no_existe")).thenReturn(List.of());
        when(cultureMediaService.findByDuration(10.0, 20.0)).thenReturn(List.of());

        List<Video> emptyTitleVideos = cultureMediaService.findByTitle("titulo_que_no_existe");
        List<Video> emptyDurationVideos = cultureMediaService.findByDuration(10.0, 20.0);

        assertEquals(0, emptyTitleVideos.size());
        assertEquals(0, emptyDurationVideos.size());
    }

    @Test
    void mockThrowVideoNotFoundException() throws VideoNotFoundException {
        when(cultureMediaService.findAll()).thenThrow(new VideoNotFoundException("Not found"));
        when(cultureMediaService.findByTitle(eq("titulo_que_no_existe"))).thenThrow(new VideoNotFoundException("Not found"));
        when(cultureMediaService.findByDuration(eq(10.0), eq(20.0))).thenThrow(new VideoNotFoundException("Not found"));

        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findByTitle("titulo_que_no_existe");
        });
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findByDuration(10.0, 20.0);
        });
    }
}