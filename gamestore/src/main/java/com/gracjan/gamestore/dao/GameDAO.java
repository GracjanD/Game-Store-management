package com.gracjan.gamestore.dao;

import com.gracjan.gamestore.entity.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameDAO {
    private EntityManager entityManager;

    @Autowired
    public GameDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Game> findById(long id){
        return Optional.ofNullable(entityManager.find(Game.class, id));
    }

    public List<Game> findAll(){
        TypedQuery<Game> theQuery = entityManager.createQuery("FROM Game", Game.class);
        return theQuery.getResultList();
    }

    public List<Game> findAllByPlatform(String platform){
        TypedQuery<Game> theQuery = entityManager.createQuery("FROM Game WHERE platform=:data", Game.class);
        theQuery.setParameter("data", platform);

        return theQuery.getResultList();
    }

    public void save(Game game){
        if(game.getId() == 0){
            entityManager.persist(game);
        } else {
            entityManager.merge(game);
        }
    }

    public Game update(Game game){
        return entityManager.merge(game);
    }

    public void deleteById(long id){
        Game game = entityManager.find(Game.class, id);
        entityManager.remove(game);
    }

    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Game", Game.class).executeUpdate();
        return numRowsDeleted;
    }
}
