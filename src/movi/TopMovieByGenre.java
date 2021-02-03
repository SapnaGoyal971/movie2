package movi;

import movi.dataclasses.Movie;
import movi.dataclasses.Rating;
import movi.utility.ParseFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopMovieByGenre {
    public static void topMovieByGenre(int gen,List<Movie> movieList, List<Rating> ratingList) throws IOException {

        List<Integer> movie_ids=new ArrayList<>();   //To get the list of movie id's with the given genre gen
        for(int i=0;i<movieList.size();i++){
            if(movieList.get(i).getGenre().get(gen)==1)
                movie_ids.add(movieList.get(i).getMovieId());
        }

       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/

        int top_average_rating_movie_id_by_genre=-1;

        float maxx=0;
        for(int j=0;j<movie_ids.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ratingList.size(); i++) {
                if (ratingList.get(i).getItemId() ==movie_ids.get(j)){
                    sum+=ratingList.get(i).getRating();
                    count++;
                }
            }
            float avg= sum/(float)count;
            if(maxx<avg){
                maxx=avg;
                top_average_rating_movie_id_by_genre=movie_ids.get(j);
            }
        }
        System.out.println("Top Movie id By Genre " +gen+ ": " +top_average_rating_movie_id_by_genre);
        System.out.println("Top Movie Name By Genre " +gen+ ": " +movieList.get(top_average_rating_movie_id_by_genre).getMovieTitle());

    }
}
