package movi.main;
import movi.dataclasses.*;
import movi.service.HighestRatedGenre;
import movi.service.MostWatchedGenreOrMovieOrMostActiveUser;
import movi.utility.ParseFromFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class movii {
    public static void main(String[] args)throws Exception {

        List<Rating> ratingList =new ArrayList<Rating>() ;
        ParseFromFile.parsing_rating(ratingList);
        List<Movie> movieList =new ArrayList<Movie>() ;
        ParseFromFile.parsing_movie(movieList);
        List<Genre> genreList =new ArrayList<Genre>() ;
        ParseFromFile.parsing_genre(genreList);
        List<User> userList =new ArrayList<User>() ;
        ParseFromFile.parsing_user(userList);



        Scanner sc3= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter 1 == Top Movie By Genre\n" +
                "2 == Top Movie By Year\n" +
                "3 == Top Movie By Year & Genre\n" +
                "4 == Most watched Movie\n" +
                "5 == Most watched Genre\n" +
                "6 == Highest rated Genre\n" +
                "7 == Most Active User\n" + "8 == Top 5 Movies By User's interest\n");
        int choice= sc3.nextInt();

        if(choice ==1) {
            System.out.print("Enter Genre id- \n");
            System.out.println("0: unknown | 1: Action | 2: Adventure | 3: Animation |" + " 4: Children's | 5: Comedy | 6: Crime | 7:Documentary | 8:Drama | 9:Fantasy |\n" + "       10:Film-Noir | 11:Horror | 12:Musical | 13:Mystery | 14:Romance | 15:Sci-Fi |" + " 16:Thriller | 17:War | 18:Western |");
            int genreId = sc3.nextInt();
             Movie movie=movi.service.TopMovie.topMovieByGenre(genreId,movieList,ratingList);
             System.out.println(movie.getMovieId()+ " "+movie.getMovieTitle());
        }

        if(choice ==2) {
            System.out.print("Enter Year- ");
            int year = sc3.nextInt();
            Movie movie=movi.service.TopMovie.topMoviesByYear(year,movieList,ratingList);
            System.out.println(movie.getMovieId()+" "+movie.getMovieTitle());
        }

        if(choice ==3) {
            System.out.print("Enter Genre id- \n");
            System.out.println("0: unknown | 1: Action | 2: Adventure | 3: Animation |" + " 4: Children's | 5: Comedy | 6: Crime | 7:Documentary | 8:Drama | 9:Fantasy |\n" + "       10:Film-Noir | 11:Horror | 12:Musical | 13:Mystery | 14:Romance | 15:Sci-Fi |" + " 16:Thriller | 17:War | 18:Western |");
            int genreId = sc3.nextInt();
            System.out.print("Enter Year- ");
            int year = sc3.nextInt();

            Movie movie=movi.service.TopMovie.topMovieByYearAndGenre(year,genreId,movieList,ratingList);
            System.out.println(movie.getMovieId()+" "+movie.getMovieTitle());
        }

        if(choice==4){
          Movie movie=  MostWatchedGenreOrMovieOrMostActiveUser.mostWatchedMovie(ratingList,movieList);
          System.out.println(movie.getMovieId()+ " "+movie.getMovieTitle());
        }

        if(choice==5){
           Genre genre= MostWatchedGenreOrMovieOrMostActiveUser.mostWatchedGenre(ratingList,movieList,genreList);
            System.out.println(genre.getGenrename());
        }

        if(choice==6){
            Genre genre=HighestRatedGenre.highestRatedGenre(ratingList,movieList,genreList);
            System.out.println(genre.getGenrename());
        }

        if(choice==7){
           User user=  MostWatchedGenreOrMovieOrMostActiveUser.mostActiveUser(ratingList,userList);
           System.out.println(user.getUserid()+" "+user.getOccupation());
        }

        if(choice == 8) {
            System.out.print("Enter User Id- ");
            int userId = sc3.nextInt();
            List<Movie> top5Movies=movi.service.Top5MoviesByUserInterest.findTop5MoviesBasedOnUserInterest(userId,ratingList,movieList);
        }

    }

}
