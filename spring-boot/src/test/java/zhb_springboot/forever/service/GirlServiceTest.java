package zhb_springboot.forever.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import zhb_springboot.forever.entity.Girl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
	
	@Autowired
	GirlService girlService;
	
	@Test
	public void findOneTest(){
		Girl girl = girlService.getGirlById(13);
		Assert.assertEquals(new Integer(19),girl.getAge());
	}

}
