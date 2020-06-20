package sichuan.umbrella.chenmm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sichuan.umbrella.chenmm.remote.GroupRemote;

@SpringBootTest
class ChenmmApplicationTests {
    @Autowired
    private GroupRemote groupRemote;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        System.out.println(groupRemote.randomGroupIds(4));
    }

}
