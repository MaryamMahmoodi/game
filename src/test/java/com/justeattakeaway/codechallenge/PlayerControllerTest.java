package com.justeattakeaway.codechallenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justeattakeaway.codechallenge.controller.PlayerController;
import com.justeattakeaway.codechallenge.model.entity.GameMove;
import com.justeattakeaway.codechallenge.model.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
public class PlayerControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testMakeMove_Player1StartsGame() throws Exception {
        GameMove initialMove = new GameMove("Player 1", 56, 0, false);
        GameMove finalMove = new GameMove("Player 1", 1, -1, true);

        when(gameService.processGame(any(GameMove.class))).thenReturn(finalMove);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = objectMapper.writeValueAsString(initialMove);

        mockMvc.perform(post("/player/move")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .headers(headers))
                .andExpect(status().isOk())
                .andExpect(content().string("Game Over! The winner is: Player 1"));
    }
}
