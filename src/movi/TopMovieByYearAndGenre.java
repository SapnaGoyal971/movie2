package movi;

import movi.dataclasses.Movie;
import movi.dataclasses.Rating;
import movi.utility.ParseFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopMovieByYearAndGenre {
    public static void topMovieByYearAndGenre(int yr, int gen,List<Movie> movieList, List<Rating> ratingList) throws IOException {

        List<Integer> movie_ids=new ArrayList<>();   //To get the list of movie id's with the given genre gen
        for(int i=0;i<movieList.size();i++){
            String curryear=movieList.get(i).getReleaseDate();
            int curryr=-1;
            if(curryear.length()>=4)
                curryr=Integer.parseInt(curryear.substring(curryear.length()-4,curryear.length()));
            if(curryr==yr && movieList.get(i).getGenre().get(gen)==1)
                movie_ids.add(movieList.get(i).getMovieId());
        }

        if(movie_ids.isEmpty())
            System.out.println("No movie released in this year");
       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/

        int top_average_rating_movie_id_by_year=-1;

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
                top_average_rating_movie_id_by_year=movie_ids.get(j);
            }
        }

        if(!movie_ids.isEmpty())
        System.out.println("Top Movie Id By Year " + yr + " and genre " + gen + ": "+top_average_rating_movie_id_by_year);
      //  System.out.println(maxx);
        if(!movie_ids.isEmpty())
        System.out.println("Top Movie Name By Year " + yr + " and genre " + gen + ": "+movieList.get(top_average_rating_movie_id_by_year).getMovieTitle());

    }
}
