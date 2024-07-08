package com.gracjan.gamestore.service;

import com.gracjan.gamestore.entity.Game;

import java.util.List;

public interface GameServiceDAO {
    List<Game> findAll();
    List<Game> findAllByPlatform(String platform);
    Game findById(long id);
    Game save(Game game);
    Game update(Game game);
    String deleteById(long id);
    String deleteAll();
}
