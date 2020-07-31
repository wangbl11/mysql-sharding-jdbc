package dao;

import com.lagou.RunBoot;
import com.lagou.entity.Position;
import com.lagou.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= RunBoot.class)
public class TestShardingDatabase {
    @Resource
    private PositionRepository positionRepository;

    @Test
    public void testAdd(){

        for (int i=1;i<=20;i++) {
            Position position=new Position();
//            position.setId(i);
            position.setName("lagou"+i);
            position.setSalary("100000");
            position.setCity("beijing");
            positionRepository.save(position);
        }
    }

}




