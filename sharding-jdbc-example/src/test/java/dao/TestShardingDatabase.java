package dao;

import com.lagou.RunBoot;
import com.lagou.entity.Position;
import com.lagou.entity.PositionDetail;
import com.lagou.repository.PositionDetailRepository;
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

    @Resource
    private PositionDetailRepository positionDetailRepository;

    @Test
    public void testAdd(){
        for (int i=1;i<=20;i++) {
            Position position=new Position();
            position.setName("lagou"+i);
            position.setSalary("100000");
            position.setCity("beijing");
            positionRepository.save(position);
        }
    }

    @Test
    public void testAdd2(){
        for (int i=1;i<=20;i++) {
            Position position=new Position();
            position.setName("lagou"+i);
            position.setSalary("100000");
            position.setCity("beijing");
            positionRepository.save(position);

            PositionDetail positionDetail=new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("This is detail for  "+position.getId());

            positionDetailRepository.save(positionDetail);

        }
    }

    @Test
    public void testLoad(){
        Object object=positionRepository.findPositionsById(496606698379673601l);
        Object[] position=(Object[])object;
        System.out.println(position[0]);
    }

}




