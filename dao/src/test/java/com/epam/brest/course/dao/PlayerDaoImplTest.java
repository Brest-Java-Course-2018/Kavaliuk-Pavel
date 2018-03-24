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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-context-test.xml", "classpath:test-db.xml",
"classpath:dao-context.xml"})
@Rollback
public class PlayerDaoImplTest {

    @Autowired
    PlayerDao playerDao;

    @Test
    public void getAllPlayersTest(){
        Collection<Player> players = playerDao.getAllPlayers();
        Assert.assertTrue(((Integer) players.size()).equals(7));
    }
}
