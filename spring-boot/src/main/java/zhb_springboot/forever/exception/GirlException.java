package zhb_springboot.forever.exception;

import zhb_springboot.forever.dic.ResultCodeEnum;

public class GirlException extends RuntimeException{
	
	private Integer code;
	
	public GirlException(ResultCodeEnum resultCodeEnum){
		super(resultCodeEnum.getMsg());
		this.code = resultCodeEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
