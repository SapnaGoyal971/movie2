package movi.service;

import movi.dataclasses.Movie;
import movi.dataclasses.Rating;

import java.io.IOException;
import java.util.*;

public class TopListOfMoviesByGenre {

    public static int userhasnotseen(int usid,int movieid, List<Rating> ratingList){
        for(int i=0;i<ratingList.size();i++){
            if(ratingList.get(i).getUserId()==usid && ratingList.get(i).getItemId()==movieid)
                return 0;
        }
        return 1;
    }

    public static List<Movie> top_list_by_genre(int genreId, int userId, List<Movie> movieList, List<Rating> ratingList) throws IOException {
        List<Integer> movieIdListContainingMoviesOfGivenGenre = new ArrayList<>();   //To get the list of movie id's with the given genre gen
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getGenre().get(genreId) == 1)
                movieIdListContainingMoviesOfGivenGenre.add(movieList.get(i).getMovieId()); //Add that movie id to movie_ids whose genre is same as our genre gen
        }

       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/
        HashMap<Integer, Float> mapMovieWithItsAverageRating = new HashMap<Integer, Float>(); //To get total average rating of the movie based on users given rating

            for(int j=0;j<movieIdListContainingMoviesOfGivenGenre.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ratingList.size(); i++) {
                if (ratingList.get(i).getItemId() ==movieIdListContainingMoviesOfGivenGenre.get(j)){
                    sum+=ratingList.get(i).getRating(); //add rating to our movie j if user's movie i is same as our movie j.
                    count++; //increase the count of movie if our movie j is same as user's movie i.
                }
            }
            float avg= sum/(float)count; //this is average total rating of our movie j
            if(userhasnotseen(userId,movieIdListContainingMoviesOfGivenGenre.get(j),ratingList)==1)
            mapMovieWithItsAverageRating.put(movieIdListContainingMoviesOfGivenGenre.get(j),avg);
        }

        mapMovieWithItsAverageRating = sortByValue(mapMovieWithItsAverageRating); //sort movies based on their average rating in descending order.

            int coun=0; //In order to keep count of first 5 movies
        List<Movie> top5Movies=new ArrayList<>();
        for (Map.Entry<Integer, Float> en : mapMovieWithItsAverageRating.entrySet()) {
            if(coun==5)
                break;
            top5Movies.add(movieList.get(en.getKey()));
                    coun++;
        }
        return top5Movies;
    }

    public static HashMap<Integer, Float> sortByValue(HashMap<Integer, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Float> > list =
                new LinkedList<Map.Entry<Integer, Float> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Float> >() {
            public int compare(Map.Entry<Integer, Float> o1,
                               Map.Entry<Integer, Float> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        // put data from sorted list to hashmap
        HashMap<Integer, Float> temp = new LinkedHashMap<Integer, Float>();
        for (Map.Entry<Integer, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}


