package com.gracjan.gamestore;


import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.repository.GameJpaRepository;
import com.gracjan.gamestore.service.GameService;
import com.gracjan.gamestore.service.GameServiceImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GamestoreUnitTests {

    private List<Game> games = new ArrayList<>();
    @Mock
    private GameJpaRepository gameRepository;

    @InjectMocks
    private GameServiceImpl gameService;

    @BeforeEach
    public void setData(){
        System.out.println("Adding 2 games...");
        games.add(new Game("Minecraft",5,"Sandbox","PC",25.99));
        games.add(new Game("The Forest",3,"Survival Horror","PC",19.49));
    }

    @AfterEach
    public void cleanUp(){
        System.out.println("Cleaning data...");
        games.clear();
    }
}
