package movi.service;

import movi.dataclasses.Genre;
import movi.dataclasses.Movie;
import movi.dataclasses.Rating;
import movi.dataclasses.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MostWatchedGenreOrMovieOrMostActiveUser {

    public static Movie mostWatchedMovie(List<Rating> ratingList, List<Movie> movieList) {
        List<Integer> movieIdFrequencyList = new ArrayList<>(Collections.nCopies(1683,0));

        for(int i=0;i<ratingList.size();i++){
            int currentMovieId=ratingList.get(i).getItemId();
            movieIdFrequencyList.set(currentMovieId,movieIdFrequencyList.get(currentMovieId)+1);
        }

        int mostWatchedMovieId=commons.FindMaximumInList(movieIdFrequencyList);
        return movieList.get(mostWatchedMovieId);
    }

    public static User mostActiveUser(List<Rating> ratingList, List<User> userList) {
        List<Integer> userIdFrequencyList = new ArrayList<>(Collections.nCopies(944,0));

        for(int i=0;i<ratingList.size();i++){
            int currentUserId=ratingList.get(i).getUserId();
            userIdFrequencyList.set(currentUserId,userIdFrequencyList.get(currentUserId)+1);
        }

        int mostActiveUserId=commons.FindMaximumInList(userIdFrequencyList);
        return userList.get(mostActiveUserId);
    }

    public static Genre mostWatchedGenre(List<Rating> ratingList, List<Movie> movieList, List<Genre> genreList) {
        List<Integer> genreFrequencyList = new ArrayList<>(Collections.nCopies(19,0));

        for(int i=0;i<ratingList.size();i++){
            int currentMovieId=ratingList.get(i).getItemId();

            List<Integer> currentGenreList = movieList.get(currentMovieId-1).getGenre();

            for(int j=0;j<currentGenreList.size();j++){
                if(currentGenreList.get(j)==1){
                    genreFrequencyList.set(j,genreFrequencyList.get(j)+1);
                }
            }
        }

        int mostWatchedGenreId=commons.FindMaximumInList(genreFrequencyList);
        return genreList.get(mostWatchedGenreId);
    }


}
