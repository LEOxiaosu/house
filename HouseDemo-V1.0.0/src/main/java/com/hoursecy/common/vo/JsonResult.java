package com.hoursecy.common.vo;

import java.io.Serializable;

public class JsonResult	implements Serializable {
	
	private static final long serialVersionUID = 2184706358271151040L;

	/** 状态码	*/
	private int state=1; // 1表示ok,0表示error
	/** 状态码对应的消息 */
	private String message="OK";
	/** 页面上要具体成呈现的数据 */
	private Object data;
	
	public JsonResult() {
	}
	
	public int getState() {
		return state;
	}
	
	public JsonResult(String message) {
		this.message=message;
	}
	/** 一般查询时,封装查询结果 */
	public JsonResult(Object data) {
		this.data=data;
	}
	/** 出异常时,调用	*/
	public JsonResult(Throwable e) {
		this.state=0;
		this.message=e.getMessage();
	}
	
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
}
