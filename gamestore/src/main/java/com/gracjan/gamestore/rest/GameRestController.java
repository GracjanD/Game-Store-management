package com.gracjan.gamestore.rest;

import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameRestController {

    private GameService gameService;

    @Autowired
    public GameRestController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getGames(){
        return gameService.findAll();
    }

    @GetMapping("/games/{gameId}")
    public Game getGameById(@PathVariable("gameId") long id) {
        return gameService.findById(id);
    }

    @PostMapping("/games")
    public Game createGame(@RequestBody Game game) {
        game.setId(0);
        return gameService.save(game);
    }

    @PutMapping("/games")
    public Game updateGame(@RequestBody Game game) {
        return gameService.save(game);
    }

    @DeleteMapping("/games")
    public String deleteGames(){
        return gameService.deleteAll();
    }

    @DeleteMapping("/games/{gameId}")
    public String deleteGameById(@PathVariable("gameId") long id){
        return gameService.deleteById(id);
    }
}
