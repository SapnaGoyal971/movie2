package movi.service;
import java.util.function.Supplier;
import java.util.logging.*;

import movi.dataclasses.Movie;
import movi.dataclasses.Rating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopMovie {

    public static Movie topMovieByGenre(int genreId, List<Movie> movieList, List<Rating> ratingList,Logger LOGGER) throws IOException {
        try {
            List<Integer> movieIdListContainingMoviesOfGivenGenre = new ArrayList<>();   //To get the list of movie id's with the given genre gen
            for (int i = 0; i < movieList.size(); i++) {
                if (movieList.get(i).getGenre().get(genreId) == 1)
                    movieIdListContainingMoviesOfGivenGenre.add(movieList.get(i).getMovieId());
            }

            LOGGER.log(Level.INFO, "Movie id's List Containing Movies of Given Genre: "+String.valueOf(movieIdListContainingMoviesOfGivenGenre));
       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/

            int top_average_rating_movie_id_by_genre = commons.findTopMovieFromRatingList(ratingList, movieIdListContainingMoviesOfGivenGenre);
            return movieList.get(top_average_rating_movie_id_by_genre);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong Genre Id");
            return null;
        }
    }

    public static Movie topMoviesByYear(int year, List<Movie> movieList, List<Rating> ratingList, Logger LOGGER) throws IOException {
        try {
            List<Integer> movieIdListContainingMoviesOfGivenYear = new ArrayList<>();   //To get the list of movie id's with the given genre gen
            for (int i = 0; i < movieList.size(); i++) {
                String currentDate = movieList.get(i).getReleaseDate();
                int currYear = -1;
                if (currentDate.length() >= 4)
                    currYear = Integer.parseInt(currentDate.substring(currentDate.length() - 4, currentDate.length()));
                if (currYear == year)
                    movieIdListContainingMoviesOfGivenYear.add(movieList.get(i).getMovieId());
            }

            LOGGER.log(Level.INFO, "Movie id's List Containing Movies of Given Year: "+String.valueOf(movieIdListContainingMoviesOfGivenYear));

       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/
            int top_average_rating_movie_id_by_year = movi.service.commons.findTopMovieFromRatingList(ratingList, movieIdListContainingMoviesOfGivenYear);
            return movieList.get(top_average_rating_movie_id_by_year);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No movie released in this year");
            return null;
        }
    }

    public static Movie topMovieByYearAndGenre(int year, int genreId,List<Movie> movieList, List<Rating> ratingList, Logger LOGGER) throws IOException {

        try {
            List<Integer> movieIdListContainingMoviesOfGivenYearAndGenre = new ArrayList<>();   //To get the list of movie id's with the given genre gen
            for (int i = 0; i < movieList.size(); i++) {
                String currentDate = movieList.get(i).getReleaseDate();
                int currYear = -1;
                if (currentDate.length() >= 4)
                    currYear = Integer.parseInt(currentDate.substring(currentDate.length() - 4, currentDate.length()));
                if (currYear == year && movieList.get(i).getGenre().get(genreId) == 1)
                    movieIdListContainingMoviesOfGivenYearAndGenre.add(movieList.get(i).getMovieId());
            }

            LOGGER.log(Level.INFO, "Movie id's List Containing Movies of Given Year and Genre: "+String.valueOf(movieIdListContainingMoviesOfGivenYearAndGenre));
       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/
            int top_average_rating_movie_id_by_year = movi.service.commons.findTopMovieFromRatingList(ratingList, movieIdListContainingMoviesOfGivenYearAndGenre);
            return movieList.get(top_average_rating_movie_id_by_year);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No movie released in this year");
            return null;
        }
    }

}
