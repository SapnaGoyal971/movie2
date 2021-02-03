package movi;

import movi.dataclasses.Genre;
import movi.dataclasses.Movie;
import movi.dataclasses.Rating;
import movi.utility.ParseFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HighestRatedGenre {
    public static void higestRatedGenre(List<Rating> ratingList, List<Movie> movieList, List<Genre> genreList) throws IOException {
        List<Long> genreids = new ArrayList<>();
        for (int i = 0; i < 19; i++)
            genreids.add(0L);

        for(int i=0;i<ratingList.size();i++){
            int currentMovieId=ratingList.get(i).getItemId();
            int currentMovieRating=ratingList.get(i).getRating();

            List<Integer> genid = movieList.get(currentMovieId-1).getGenre();
            for(int j=0;j<genid.size();j++){
                if(genid.get(j)==1){
                    genreids.set(j,genreids.get(j)+currentMovieRating);
                }
            }
        }

        int highestratedgenreid=-1;
        Long maxx= Long.valueOf(0);
        for(int i=0;i<genreids.size();i++){
            //   System.out.println(genreids.get(i));
            if(maxx<genreids.get(i)){
                maxx=genreids.get(i);
                highestratedgenreid=i;
            }
        }
        System.out.println("Highest Rated Genre Id: "+ highestratedgenreid);
        System.out.println("Highest Rated Genre Name: "+genreList.get(highestratedgenreid).getGenrename());
    }
}
