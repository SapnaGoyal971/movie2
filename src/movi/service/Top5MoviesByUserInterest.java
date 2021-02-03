package movi.service;

import movi.dataclasses.Movie;
import movi.dataclasses.Rating;
import movi.service.TopListOfMoviesByGenre;

import java.io.IOException;
import java.util.*;


public class Top5MoviesByUserInterest {

    public static List<Movie> findTop5MoviesBasedOnUserInterest(int userId, List<Rating> ratingList, List<Movie> movieList) throws IOException {

        List<Integer> movieListThatUserHasSeen=new ArrayList<>();//In order to find the list of movies that user has seen

        Map<Integer,Integer> mapMovieIdWithRatingThatUserHasSeen=new HashMap<Integer,Integer>(); //In order to map the movie id with the rating that user have given to that movie

        for(int i=0;i< ratingList.size();i++){
            if(userId==ratingList.get(i).getUserId()){
                movieListThatUserHasSeen.add(ratingList.get(i).getItemId());   //If user's id and current userid mathes then add tat movie rated by our user to movies list.
                mapMovieIdWithRatingThatUserHasSeen.put(ratingList.get(i).getItemId(),ratingList.get(i).getRating()); //Add the rating that user has given to that item(movie) to map.
            }
        }


        List<Integer> genreRatingListAccordingToUsersSeenMovies=new ArrayList<>(Collections.nCopies(19,0)); //In order to find the genre's points based on user's interest

        for(int j=0;j<movieListThatUserHasSeen.size();j++){
            for(int i=0;i<movieList.size();i++){

                if(movieListThatUserHasSeen.get(j)==movieList.get(i).getMovieId()){
                    for(int k=0;k<19;k++){
                      genreRatingListAccordingToUsersSeenMovies.set(k,genreRatingListAccordingToUsersSeenMovies.get(k)+ mapMovieIdWithRatingThatUserHasSeen.get(movieListThatUserHasSeen.get(j))*movieList.get(i).getGenre().get(k));
//In this we have added genre k to the movie's(that user have seen) genre k multiplied to the points that user has given to that movie
                    }
                }

            }
        }

        Map<Integer,Integer> mapGenreRatingValueToRatingIndex=new HashMap<Integer,Integer>();//In order to keep track of genre's index even after sorting
        for(int i=0;i<19;i++) {
            mapGenreRatingValueToRatingIndex.put(genreRatingListAccordingToUsersSeenMovies.get(i),i);
        }

        Collections.sort(genreRatingListAccordingToUsersSeenMovies, Collections.reverseOrder());

        /*for(int i=0;i<19;i++)
            System.out.println(genre.get(i));*/
//We have got the list of genres that a user likes from most favourite to least favourite

        //Now we will have to find top 5 movies based on user's favorite genres
        List<Movie> top5Movies= TopListOfMoviesByGenre.topListOfMoviesByGenre(mapGenreRatingValueToRatingIndex.get(genreRatingListAccordingToUsersSeenMovies.get(0)),userId,movieList,ratingList); //To get top 5 movies based on user's most favourite genre.
        return top5Movies;
    }
}
