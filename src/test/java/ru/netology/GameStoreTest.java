package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты

    @Test
    public void shouldReturnFalseAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("игра 2", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldSumPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("1", 5);
        store.addPlayTime("2", 10);

        int expected = 15;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("игра 1", "бродилка");
        store.addPlayTime("1", 10);
        store.addPlayTime("1", 15);
        store.addPlayTime("2", 20);
        store.addPlayTime("2", 2);

        String expected = "1";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerReturnNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("игра 2", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegative() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Petya", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }
    @Test
    public void shouldRegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 0);
        store.addPlayTime("Petya", 6);


        String actual = store.getMostPlayer();
        String expected = "Petya";
        assertEquals(expected, actual);
    }
}
