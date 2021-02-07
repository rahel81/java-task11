package ru.netology.manager;


import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    int maxLength = 10;

    public MovieManager() {
    }

    public MovieManager(int maxLength) {
        if (maxLength >= 0) {
            this.maxLength = maxLength;
        }
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        int length = movies.length > maxLength ? maxLength : movies.length;

        Movie[] result = new Movie[length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getLast() {
        return movies;
    }
}






