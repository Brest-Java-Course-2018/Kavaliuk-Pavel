package com.epam.brest.course.dao;

import com.epam.brest.course.model.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-context-test.xml",
        "classpath:test-db.xml", "classpath:dao-context.xml"})
@Rollback
public class PlayerDaoImplTest {

    private static final int PLAYER_NUMBER = 1;
    private static final String PLAYER_NAME = "player name";

    @Autowired
    PlayerDao playerDao;

    @Test
    public void getAllPlayersTest(){
        Collection<Player> players = playerDao.getAllPlayers();
        Assert.assertTrue(((Integer) players.size()).equals(7));
    }

    @Test
    public void deletePlayerByIdTest(){
        Integer wasCount = playerDao.getAllPlayers().size();
        playerDao.deletePlayerById(1);

        Assert.assertTrue(((Integer) playerDao.getAllPlayers()
                .size()).equals(wasCount - 1));
    }

    @Test
    public void addPlayerTest(){
        Player player = new Player(PLAYER_NUMBER, PLAYER_NAME,
                PLAYER_NUMBER, PLAYER_NUMBER, PLAYER_NUMBER);

        Player player1 = playerDao.addPlayer(player);
        Assert.assertTrue(player1.getPlayerName().equals(player.getPlayerName()));
        Assert.assertTrue(player1.getPlayerAge().equals(player.getPlayerAge()));
        Assert.assertTrue(player1.getPlayerCost().equals(player.getPlayerCost()));
        Assert.assertTrue(player1.getPlayerNumber().equals(player.getPlayerNumber()));
        Assert.assertTrue(player1.getPlayerTeamId().equals(player.getPlayerTeamId()));
    }

//    @Test
//    public void updatePlayerTest(){
//
//
//        Player player = new Player(PLAYER_NUMBER + PLAYER_NUMBER,
//                PLAYER_NAME, PLAYER_NUMBER + PLAYER_NUMBER,
//                PLAYER_NUMBER + PLAYER_NUMBER, PLAYER_NUMBER + PLAYER_NUMBER);
//        playerDao.updatePlayer(player);
//        List<Player> players = (List<Player>) playerDao.getAllPlayers();
//        Assert.assertTrue(players.get(player.getPlayer_id()).getPlayerAge().equals(PLAYER_NUMBER + PLAYER_NUMBER));
//
//    }
}
