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
    public void getSumPlayedTimeTest() {
        GameStore store = new GameStore();
        store.addPlayTime("1", 5);
        store.addPlayTime("2", 10);

        int expected = 15;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerTest() {
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
}
