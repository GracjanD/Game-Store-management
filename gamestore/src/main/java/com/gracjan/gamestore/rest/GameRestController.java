package com.gracjan.gamestore.rest;

import com.gracjan.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameRestController {

    private GameService gameService;

    @Autowired
    public GameRestController(GameService gameService){
        this.gameService = gameService;
    }
}
