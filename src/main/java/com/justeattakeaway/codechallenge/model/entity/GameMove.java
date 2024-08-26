package com.justeattakeaway.codechallenge.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Details about a game move")
public class GameMove
{
    @Schema(description = "Name of the player", example = "Player 1")
    private String playerName;

    @Schema(description = "The current number in the game", example = "56")
    private int number;

    //@Schema(hidden = true) // Hides this field in Swagger UI
    @JsonIgnore
    private int addedValue;

    @JsonIgnore
    private boolean isGameOver;
}
