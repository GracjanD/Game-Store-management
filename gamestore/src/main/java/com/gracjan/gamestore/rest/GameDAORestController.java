package com.gracjan.gamestore.rest;

import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.service.GameServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dao")
public class GameDAORestController {
    private GameServiceDAO gameServiceDAO;

    @Autowired
    public GameDAORestController(GameServiceDAO gameServiceDAO) {
        this.gameServiceDAO = gameServiceDAO;
    }

    @GetMapping("/games")
    public List<Game> getGames(){
        return gameServiceDAO.findAll();
    }

    @GetMapping("/games/platform/{gamePlatform}")
    public List<Game> getGames(@PathVariable("gamePlatform") String platform){
        return gameServiceDAO.findAllByPlatform(platform);
    }

    @GetMapping("/games/{gameId}")
    public Game getGameById(@PathVariable("gameId") long id){
        return gameServiceDAO.findById(id);
    }

    @PostMapping("/games")
    public Game createGame(@RequestBody Game game){
        return gameServiceDAO.save(game);
    }

    @PutMapping("/games")
    public Game updateGame(@RequestBody Game game){
        return gameServiceDAO.update(game);
    }

    @DeleteMapping("/games/{gameId}")
    public String deleteGameById(@PathVariable("gameId") long id){
        return gameServiceDAO.deleteById(id);
    }

    @DeleteMapping("/games")
    public String deleteAllGames(){
        return gameServiceDAO.deleteAll();
    }
}
