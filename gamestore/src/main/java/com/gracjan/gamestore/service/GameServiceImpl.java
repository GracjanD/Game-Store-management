package com.gracjan.gamestore.service;

import com.gracjan.gamestore.repository.GameJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    private GameJpaRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameJpaRepository gameRepository){
        this.gameRepository = gameRepository;
    }
}
