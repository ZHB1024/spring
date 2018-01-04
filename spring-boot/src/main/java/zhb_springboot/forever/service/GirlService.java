package zhb_springboot.forever.service;

import java.util.List;

import zhb_springboot.forever.entity.Girl;


public interface GirlService {
	
	Girl save(Girl girl);
	
	void insertTwo();
	
	List<Girl> getGirls();
	
	 Girl getGirlById(Integer id);
	 
	 void getGirlByAge(Integer id) throws Exception;

}
