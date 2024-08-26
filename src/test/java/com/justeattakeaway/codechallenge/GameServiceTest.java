package com.justeattakeaway.codechallenge;

import com.justeattakeaway.codechallenge.model.entity.GameMove;
import com.justeattakeaway.codechallenge.model.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest
{
    private GameService gameService;

    @BeforeEach
    public void setUp(){
      gameService = new GameService();
    }

    @Test
    public void testProcessGame_Player1Wins() {
        GameMove initialMove = new GameMove("Player 1", 56, 0, false);
        GameMove finalMove = gameService.processGame(initialMove);

        assertTrue(finalMove.isGameOver());
        assertEquals("Player 1", finalMove.getPlayerName());
        assertEquals(1, finalMove.getNumber());
    }

    @Test
    public void testProcessGame_Player2Wins() {
        GameMove initialMove = new GameMove("Player 2", 10, 0, false);
        GameMove finalMove = gameService.processGame(initialMove);

        assertTrue(finalMove.isGameOver());
        assertEquals("Player 2", finalMove.getPlayerName());
        assertEquals(1, finalMove.getNumber());
    }

}
