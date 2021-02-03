package movi.utility;

import movi.dataclasses.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ParseFromFile {

    public static void parsing_user(List<User> userList) throws IOException {

        File file = new File("src/DataFiles/user.data");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String readString;
        while ((readString = br.readLine()) != null) {
            String[] parts = readString.split(Pattern.quote("|"));
            User user = new User();
            user.setUserid(Integer.parseInt(parts[0]));
            user.setAge(Integer.parseInt(parts[1]));
            user.setGender(parts[2]);
            user.setOccupation(parts[3]);
            user.setZipcode(parts[4]);
           /* System.out.println(parts[0]);
            System.out.println(string);*/

            userList.add(user);
        }

    }
    public static void parsing_rating(List<Rating> ratingList) throws IOException{

        File file = new File("src/DataFiles/ratings.data");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String readString;
        while ((readString = br.readLine()) != null) {
            StringTokenizer parts = new StringTokenizer(readString);
            Rating rating = new Rating();
            rating.setUserId(Integer.parseInt(parts.nextToken()));
            rating.setItemId(Integer.parseInt(parts.nextToken()));
            rating.setRating(Integer.parseInt(parts.nextToken()));
          /*  System.out.println(parts.nextToken());
            System.out.println(string);*/

            ratingList.add(rating);
        }

    }
    public static void parsing_movie(List<Movie> movieList) throws IOException {

        File file = new File("src/DataFiles/movie.data");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String readString;
        while ((readString = br.readLine()) != null) {
            String[] parts = readString.split(Pattern.quote("|"));
            Movie movie = new Movie();
            movie.setMovieId(Integer.parseInt(parts[0]));
            movie.setMovieTitle(parts[1]);
            movie.setReleaseDate(parts[2]);
            movie.setIMDbURL(parts[4]);
         /*   System.out.println(parts[3]);
            System.out.println(string);*/

            List<Integer> genreList = new ArrayList<>();
            for(int i=0;i<19;i++){
                genreList.add(Integer.parseInt(parts[i+5]));
            }
            movie.setGenre(genreList);

            movieList.add(movie);
        }
    }
    public static void parsing_genre(List<Genre> genreList) throws IOException {

        File file = new File("src/DataFiles/genre.data");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String readString;
        while ((readString = br.readLine()) != null) {
            String[] parts = readString.split(Pattern.quote("|"));
            Genre genre = new Genre();
            if(parts.length==2) {
                genre.setGenrename(parts[0]);
                genre.setGenreid(Integer.parseInt(parts[1]));
               /* System.out.println(parts[1]);
                System.out.println(string);*/
            }

            genreList.add(genre);
        }


    }



}
