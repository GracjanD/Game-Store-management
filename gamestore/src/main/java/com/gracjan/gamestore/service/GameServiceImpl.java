package com.gracjan.gamestore.service;

import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.exception.GameNotFoundException;
import com.gracjan.gamestore.repository.GameJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    private GameJpaRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameJpaRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(long id) {
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Not found game with id: " + id));
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public String deleteById(long id) {
        findById(id);
        gameRepository.deleteById(id);
        return "Deleted game with id: " + id;
    }

    @Override
    public String deleteAll() {
        long count = gameRepository.count();
        gameRepository.deleteAll();
        return "Deleted " + count + " games";
    }

    @PostConstruct
    public void createInitialData(){
        gameRepository.save(new Game("Minecraft", 5, "Sandbox", "PC", 10.99));
        gameRepository.save(new Game("7 Days To Die", 7, "Zombie Apocalypse", "PlayStation 5", 12.34));
    }

    @PreDestroy
    public void cleanup(){
        gameRepository.deleteAll();
    }

}
