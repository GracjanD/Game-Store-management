package com.gracjan.gamestore.service;

import com.gracjan.gamestore.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> findAll();
    Game findById(long id);
    Game save(Game game);
    String deleteById(long id);
    String deleteAll();
}
