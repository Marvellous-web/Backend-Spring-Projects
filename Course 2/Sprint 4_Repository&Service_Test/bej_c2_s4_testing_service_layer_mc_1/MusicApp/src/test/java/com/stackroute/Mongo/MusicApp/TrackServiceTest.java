package com.stackroute.Mongo.MusicApp;

import com.stackroute.Mongo.MusicApp.exception.TrackAlreadyExistException;
import com.stackroute.Mongo.MusicApp.exception.TrackNotFoundException;
import com.stackroute.Mongo.MusicApp.model.Artist;
import com.stackroute.Mongo.MusicApp.model.Track;
import com.stackroute.Mongo.MusicApp.repository.TrackRepository;
import com.stackroute.Mongo.MusicApp.service.TrackServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TrackServiceTest {
    @Mock
    private TrackRepository trackRepository;
    @InjectMocks
    private TrackServiceImpl trackService;

    private Track track;
    private Artist artist;

    @BeforeEach
    public void setup(){
       track=new Track("TR001","XYZ","5.5",
               new Artist("AR1","ABC"));
    }
    @AfterEach
    public void clean(){
        track=null;
        artist=null;
    }
    @Test
    //success test case for addTrackMethod
    public void testAddTrackSuccess() throws TrackAlreadyExistException {
        //if repository call findById() method then return the empty optional object
        //if repository call save() method then return the book object
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
        when(trackRepository.save(track)).thenReturn(track);
        assertEquals(track,trackService.addTrack(track));
        verify(trackRepository,times(1)).findById(track.getTrackId());
        //verify how many times call the findById() method in repo.
        verify(trackRepository,times(1)).save(track);
        //verify how many times call the save method in repo.
    }

    @Test
    //test case for failure addTrack() method
    public void testAddTrackFailure(){
        //if repo call the findById() method then return the optional obj with book
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.of(track));
        assertThrows(TrackAlreadyExistException.class,()->trackService.addTrack(track));
        //verify, how many times call the save and findById method
        verify(trackRepository,times(1)).findById(track.getTrackId());
        verify(trackRepository,times(0)).save(track);
    }

    @Test //success test case for deleteTrack()
    public void testDeleteTrackSuccess() throws TrackNotFoundException {
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(track));
        boolean result=trackService.deleteTrack(track.getTrackId());
        assertEquals(true,result);
        verify(trackRepository,times(1)).findById(track.getTrackId());
        verify(trackRepository,times(1)).deleteById(track.getTrackId());
    }

    @Test //failure test case for deleteTrack()
    public void testDeleteTrackFailure() throws TrackNotFoundException {
        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
        assertThrows(TrackNotFoundException.class,()->trackService.deleteTrack(track.getTrackId()));
        verify(trackRepository,times(1)).findById(track.getTrackId());
        verify(trackRepository,times(0)).deleteById(track.getTrackId());

    }

//    @Test //success test for updateTrack
//    public void testUpdateTrackSuccess() throws TrackNotFoundException {
//        when(trackRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
//        when(trackRepository.save(track)).thenReturn(track);
//        assertEquals(track,trackService.updateTrack(track));
//        verify(trackRepository,times(1)).findById(track.getTrackId());
//        verify(trackRepository,times(0)).deleteById(track.getTrackId());
//    }

    @Test //test case for get all track
    public void testGetAllTrack(){
        Track result=new Track("TR002","Bandiya","5.5",artist);
        when(trackRepository.findAll()).thenReturn(List.of(track,result));
        assertIterableEquals(Arrays.asList(track,result),trackService.getAllTracks());
        verify(trackRepository,times(1)).findAll();
    }

    @Test //test case for getTrack by rating (custom method)
    public void testGetTrackByRating() throws TrackNotFoundException {
        //inserting the new records in list
        Track result1=new Track("TR003","Bandiya","5.5",artist);
        //
        when(trackRepository.getAllTrackByRating(track.getTrackRating())).thenReturn(List.of(track,result1));
        assertIterableEquals(Arrays.asList(track,result1),trackService.getAllTrackByRating(track.getTrackRating()));
    }

}
