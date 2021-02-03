package movi.dataclasses;

import java.util.ArrayList;
import java.util.List;

public class Movie {
   private int movieId;
   private String movieTitle ;
   private String releaseDate ;
   private String videoReleaseDate ;
   private String IMDbURL ;
   private List<Integer> genre=new ArrayList<>();


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVideoReleaseDate() {
        return videoReleaseDate;
    }

    public void setVideoReleaseDate(String videoReleaseDate) {
        this.videoReleaseDate = videoReleaseDate;
    }

    public String getIMDbURL() {
        return IMDbURL;
    }

    public void setIMDbURL(String IMDbURL) {
        this.IMDbURL = IMDbURL;
    }

    public List<Integer> getGenre() {
        return genre;
    }

    public void setGenre(List<Integer> genre) {
        this.genre = genre;
    }
}
