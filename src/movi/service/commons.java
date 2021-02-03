package movi.service;

import movi.dataclasses.Rating;

import java.util.List;

public class commons {
    public static int FindMaximumInList(List<Integer> integerList){
        int maxFrequencyId=-1;
        int maxFrequency=-1;
        for(int i=0;i<integerList.size();i++){
            //   System.out.println(integerList.get(i));
            if(maxFrequency<integerList.get(i)){
                maxFrequency=integerList.get(i);
                maxFrequencyId=i;
            }
        }
        return maxFrequencyId;
    }

    public static int findTopMovieFromRatingList(List<Rating> ratingList, List<Integer> movieList){

        int top_average_rating_movie_id=-1;

        float maxx=0;
        for(int j=0;j<movieList.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ratingList.size(); i++) {
                if (ratingList.get(i).getItemId() ==movieList.get(j)){
                    sum+=ratingList.get(i).getRating();
                    count++;
                }
            }
            float avg= sum/(float)count;
            if(maxx<avg){
                maxx=avg;
                top_average_rating_movie_id=movieList.get(j);
            }
        }
        return top_average_rating_movie_id;
    }
}
