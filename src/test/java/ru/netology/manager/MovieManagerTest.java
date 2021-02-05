package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    MovieManager manager = new MovieManager();

    private Movie first = new Movie(1, "Бладшот", "боевик");
    private Movie second = new Movie(2, "Вперед", "мультфильм");
    private Movie third = new Movie(3, "Отель Белград", "комедия");
    private Movie fourth = new Movie(4, "Джентльмены", "боевик");
    private Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    private Movie seventh = new Movie(7, "Номер один", "комедия");
    private Movie eighth = new Movie(8, "Пункт назначения", "ужасы");
    private Movie ninth = new Movie(9, "Скайлайн", "фантастика");
    private Movie tenth = new Movie(10, "Афера века", "комедия");
    private Movie eleventh = new Movie(11, "Грейхаунд", "военный");
    private Movie twelfth = new Movie(12, "Банкир", "драма");

    @BeforeEach
    public void setUp() {
        MovieManager manager = new MovieManager();
    }

    @Test
    void shouldPrintOnlyLastTen() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintAllLast() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintOnlyLastFiveOutFive() {

        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] expected = new Movie[]{tenth, ninth, eighth,
                seventh, sixth};
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintOnlyLastTwoOutTwo() {

        manager.add(sixth);
        manager.add(seventh);

        Movie[] expected = new Movie[]{seventh, sixth};
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintOnlyLastTenIfMoreTen() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintIfZero() {

        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintOnlyLastFiveIfTen() {
        MovieManager manager = new MovieManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldPrintTenIfUnderZero() {
        MovieManager manager = new MovieManager(-3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] expected = new Movie[]{tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, manager.getAll());
    }
}

