package com.gracjan.gamestore;


import com.gracjan.gamestore.entity.Game;
import com.gracjan.gamestore.repository.GameJpaRepository;
import com.gracjan.gamestore.service.GameService;
import com.gracjan.gamestore.service.GameServiceImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
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

}
