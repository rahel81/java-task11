package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    int maxLength = 10;
    int newLength;

    public MovieManager() {
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
        int length = movies.length;

        if (newLength <= 0) {
            if (maxLength < movies.length) {
                length = maxLength;
            }
        } else {
            if (newLength < movies.length) {
                length = newLength;
            }
        }

            Movie[] result = new Movie[length];
            for (int i = 0; i < result.length; i++) {
                int index = movies.length - i - 1;
                result[i] = movies[index];
            }
            return result;
        }


    public MovieManager(int newLength) {
            this.newLength = newLength;
        }
}