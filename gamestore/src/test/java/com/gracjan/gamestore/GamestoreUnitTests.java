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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GamestoreUnitTests {

    private List<Game> games = new ArrayList<>();
    @Mock
    private GameJpaRepository gameRepository;

    @InjectMocks
    private GameServiceImpl gameService;

    @Test
    @Order(1)
    public void test_findAll(){
        // set up
        when(gameRepository.findAll()).thenReturn(games);

        // execute
        List<Game> gameList = gameService.findAll();

        // assert
        assertEquals(games.get(0).getTitle(), gameList.get(0).getTitle(),
                "Game title should be the same.");
        assertEquals(games.size(), gameList.size(),
                "Lists should have the same size.");
        assertNotNull(games.get(0),
                "Game shouldn't be null");

        // verify if gameRepository was executed only once.
        verify(gameRepository, times(1)).findAll();
    }

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
