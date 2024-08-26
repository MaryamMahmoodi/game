package com.justeattakeaway.codechallenge.model.service;

import com.justeattakeaway.codechallenge.model.entity.GameMove;
import org.springframework.stereotype.Service;

@Service
public class GameService
{
    public GameMove processGame(GameMove initialMove)
    {
        GameMove currentMove = initialMove;

        // Loop until the game is over
        while (!currentMove.isGameOver())
        {
            currentMove = processMove(currentMove);
        }

        return currentMove; // This will be the final move where the game is over
    }

    private GameMove processMove(GameMove incomingMove)
    {
        int currentNumber = incomingMove.getNumber();
        int addedValue = calculateOptimalMove(currentNumber);

        int newNumber = (currentNumber + addedValue) / 3;
        boolean isGameOver = newNumber == 1;
        // Determine the next player
        String nextPlayer = getNextPlayer(incomingMove.getPlayerName());
        return new GameMove(nextPlayer, newNumber, addedValue, isGameOver);
    }


    private int calculateOptimalMove(int number)
    {
        if ((number - 1) % 3 == 0)
        {
            return -1;
        }
        else if ((number + 1) % 3 == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    private String getNextPlayer(String currentPlayer)
    {
        // Alternates between "Player 1" and "Player 2"
        return "Player 1".equals(currentPlayer) ? "Player 2" : "Player 1";
    }

}
