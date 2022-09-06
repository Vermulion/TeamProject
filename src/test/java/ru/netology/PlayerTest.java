package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    GameStore store = new GameStore();

    Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("Крестики-нолики", "Аркады");
    Game game3 = store.publishGame("CivillizationVI", "Пошаговая стратегия");

    Player player1 = new Player("Petya");
    Player player2 = new Player("Masha");

    @Test
    public void shouldSumGenreIfOneGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Акрады");

        Player player = new Player ("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void shouldSumGenreIfSeveralGames() {

        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 4);
        player1.play(game2, 1);

        int expected = 5;
        int actual = player1.sumGenre(game1.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfPlayReplays() {

        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 4);
        player1.play(game1, 1);

        int expected = 5;
        int actual = player1.sumGenre("Аркады");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGiveSumZero() {

        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 4);
        player1.play(game1, 1);

        int expected = 0;
        int actual = player1.sumGenre("Пошаговая стратегия");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnMostPlayedGenre() {
        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 2);
        player1.play(game2, 8); // значение исправила на игрока 2


        Game expected = game2;
        Game actual = player1.mostPlayerByGenre("Аркады");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMostPlayedGenreFirst() {
        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 20);
        player1.play(game2, 8); // значение исправила на игрока 2


        Game expected = game1;
        Game actual = player1.mostPlayerByGenre("Аркады");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnMostPlayedGenreNull() {
        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 2);
        player1.play(game2, 8);


        Game[] expected = null;
        Game actual = player1.mostPlayerByGenre(game3.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameWasNotInstalledShouldShowException() {
        player1.installGame(game1);

        Assertions.assertThrows(RuntimeException.class, () -> {
            player1.play(game2, 5);
        });
    }
    // другие ваши тесты
}
