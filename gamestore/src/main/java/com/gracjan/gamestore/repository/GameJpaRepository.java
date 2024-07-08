package com.gracjan.gamestore.repository;

import com.gracjan.gamestore.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameJpaRepository extends JpaRepository<Game, Long> {
}
