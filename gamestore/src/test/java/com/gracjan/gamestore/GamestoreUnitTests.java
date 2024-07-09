package com.gracjan.gamestore;


import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.repository.GameJpaRepository;
import com.gracjan.gamestore.service.GameService;
import com.gracjan.gamestore.service.GameServiceImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    // findAll()
    @Test
    @Order(1)
    public void test_findAll_shouldReturnTheSameSize(){
        // arrange
        when(gameRepository.findAll()).thenReturn(games);

        // act
        List<Game> gameList = gameService.findAll();

        // assert
        // check if the size of the lists are the same
        assertEquals(games.size(), gameList.size(),
                "Lists should have the same size.");
    }

    @Test
    @Order(2)
    public void test_findAll_shouldBeNotEmpty(){
        // arrange
        when(gameRepository.findAll()).thenReturn(games);

        // act
        List<Game> gameList = gameService.findAll();

        // assert
        // check if the list is not empty
        assertFalse(gameList.isEmpty(),
                "List shouldn't be empty");
    }

    @Test
    @Order(3)
    public void test_findAll_shouldReturnTheSameGames(){
        // arrange
        when(gameRepository.findAll()).thenReturn(games);

        // act
        List<Game> gameList = gameService.findAll();

        // assert
        // check if the lists are deeply equal
        assertIterableEquals(games, gameList,
                "Lists should have the same data");

        // verify if gameRepository was executed only once.
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    @Order(4)
    public void test_findAll_shouldReturnNotNullGames(){
        // arrange
        when(gameRepository.findAll()).thenReturn(games);

        // act
        List<Game> gameList = gameService.findAll();

        // assert
        for(int i = 0; i < gameList.size(); i++){
            // check if the game is not null
            assertNotNull(games.get(i),
                    "Game shouldn't be null");
        }

        // verify if gameRepository was executed only once.
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    @Order(5)
    public void test_findAll_shouldReturnTheSameTitle(){
        // arrange
        when(gameRepository.findAll()).thenReturn(games);

        // act
        List<Game> gameList = gameService.findAll();

        // assert
        for(int i = 0; i < gameList.size(); i++){
            // check if the games have the same title
            assertEquals(games.get(i).getTitle(), gameList.get(i).getTitle(),
                    "Game title should be the same.");
        }

        // verify if gameRepository was executed only once.
        verify(gameRepository, times(1)).findAll();
    }

    @ParameterizedTest(name="gameId={0}")
    @ValueSource(longs = {0, 1})
    @Order(6)
    public void test_findById(long value){
        // set up
        when(gameRepository.findById(value)).thenReturn(Optional.ofNullable(games.get((int) value)));

        // execute
        Game game = gameService.findById(value);

        // assert
        assertNotNull(game, "Game shouldn't be null");

        // verify
        verify(gameRepository, times(1)).findById(value);
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
