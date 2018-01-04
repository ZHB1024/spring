package zhb_springboot.forever.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhb_springboot.forever.dic.ResultCodeEnum;
import zhb_springboot.forever.entity.Girl;
import zhb_springboot.forever.entity.repository.GirlRepository;
import zhb_springboot.forever.exception.GirlException;
import zhb_springboot.forever.service.GirlService;

@Service
public class GirlServiceImpl implements GirlService {
	
	@Autowired
	GirlRepository girlRepository;
	
	public Girl save(Girl girl){
		girlRepository.save(girl);
		return girl;
	}
	
	@Transactional
	public void insertTwo(){
		Girl girl1 = new Girl();
		girl1.setId(12);
		girl1.setAge(18);
		girl1.setCupSize("B");
		girl1.setMoney(400d);
		girlRepository.save(girl1);
		
		Girl girl2 = new Girl();
		girl2.setId(13);
		girl2.setAge(19);
		girl2.setCupSize("C");
		girl2.setMoney(500d);
		girlRepository.save(girl2);
		
	}

	public List<Girl> getGirls() {
		return girlRepository.findAll();
	}
	
	public Girl getGirlById(Integer id){
		return girlRepository.findOne(id);
	}
	
	public void getGirlByAge(Integer id) throws Exception{
		Girl girl = girlRepository.findOne(id);
		if (null == girl) {
			throw new GirlException(ResultCodeEnum.UNKONW_ERROR);
		}else if (girl.getAge() < 10) {
			throw new GirlException(ResultCodeEnum.PRIMARY_SCHOOL);
		}else if (girl.getAge() > 10 && girl.getAge() < 15) {
			throw new GirlException(ResultCodeEnum.MIDDLE_SCHOOL);
		}else {
			throw new GirlException(ResultCodeEnum.SUCCESS);
		}
	}

}
