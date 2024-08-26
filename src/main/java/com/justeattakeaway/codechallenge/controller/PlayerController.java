package com.justeattakeaway.codechallenge.controller;

import com.justeattakeaway.codechallenge.model.entity.GameMove;
import com.justeattakeaway.codechallenge.model.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController
{

    @Autowired
    private GameService gameService;

    @Operation(summary = "Return the winner of the game")
    @ApiResponse(responseCode = "200", description = "Game Over successfully")
    @PostMapping("/move")
    public ResponseEntity<String> makeMove(@RequestBody GameMove incomingMove)
    {
        if (incomingMove.getPlayerName() == null || incomingMove.getPlayerName().trim().isEmpty())
        {
            return ResponseEntity.badRequest().body("Player name must not be empty");
        }

        incomingMove.setAddedValue(0);
        incomingMove.setGameOver(false);
        GameMove finalMove = gameService.processGame(incomingMove);

        return ResponseEntity.ok("Game Over! The winner is: " + finalMove.getPlayerName());

    }
}
