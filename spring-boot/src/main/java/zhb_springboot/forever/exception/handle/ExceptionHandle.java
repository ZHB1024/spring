package zhb_springboot.forever.exception.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import zhb_springboot.forever.dic.ResultCodeEnum;
import zhb_springboot.forever.entity.Girl;
import zhb_springboot.forever.exception.GirlException;
import zhb_springboot.forever.exception.Result;
import zhb_springboot.forever.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	private Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<Girl> handle(Exception e){
		if (e instanceof GirlException) {
			GirlException girlException = (GirlException)e;
			return ResultUtil.error(girlException.getCode(), girlException.getMessage());
		}else{
			log.error("【系统异常】{}",e);
			return ResultUtil.error(ResultCodeEnum.UNKONW_ERROR.getCode(),ResultCodeEnum.UNKONW_ERROR.getMsg());
		}
		
	}

}
