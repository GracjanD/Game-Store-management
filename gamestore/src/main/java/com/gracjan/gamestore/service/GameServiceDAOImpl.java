package com.gracjan.gamestore.service;

import com.gracjan.gamestore.dao.GameDAO;
import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.exception.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceDAOImpl implements GameServiceDAO{
    private GameDAO gameDAO;

    @Autowired
    public GameServiceDAOImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public Game findById(long id){
        Optional<Game> game = gameDAO.findById(id);

        Game newGame = null;
        if(game.isPresent()){
            newGame = game.get();
        } else {
            throw new GameNotFoundException("Not found game with id: " + id);
        }
        return newGame;
    }

    @Override
    public List<Game> findAllByPlatform(String platform){
        return gameDAO.findAllByPlatform(platform);
    }
    @Override
    public List<Game> findAll(){
        return gameDAO.findAll();
    }

    @Override
    @Transactional
    public Game save(Game game){
        gameDAO.save(game);
        return game;
    }

    @Override
    @Transactional
    public Game update(Game game){
        return gameDAO.update(game);
    }

    @Override
    @Transactional
    public String deleteById(long id){
        gameDAO.deleteById(id);
        return "Deleted game with id: " + id;
    }

    @Override
    @Transactional
    public String deleteAll(){
        int numRowsDeleted = gameDAO.deleteAll();
        return "Deleted " + numRowsDeleted + " games";
    }
}
