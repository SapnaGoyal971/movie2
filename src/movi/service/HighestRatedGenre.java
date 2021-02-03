package movi.service;

import movi.dataclasses.Genre;
import movi.dataclasses.Movie;
import movi.dataclasses.Rating;
import movi.utility.ParseFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighestRatedGenre {
    public static Genre highestRatedGenre(List<Rating> ratingList, List<Movie> movieList, List<Genre> genreList) throws IOException {
        List<Long> genreIdList = new ArrayList<>(Collections.nCopies(19,0L));

        for(int i=0;i<ratingList.size();i++){
            int currentMovieId=ratingList.get(i).getItemId();
            int currentMovieRating=ratingList.get(i).getRating();

            List<Integer> currentGenIdList = movieList.get(currentMovieId-1).getGenre();

            for(int j=0;j<currentGenIdList.size();j++){
                if(currentGenIdList.get(j)==1){
                    genreIdList.set(j,genreIdList.get(j)+currentMovieRating);
                }
            }
        }
        int highestRatedGenreId=movi.service.commons.FindMaximumInList2(genreIdList);
        return genreList.get(highestRatedGenreId);
    }
}
