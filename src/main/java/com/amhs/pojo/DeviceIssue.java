package com.amhs.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
/**
 * -实体类
 * @author Sun.chuanwang
 *
 */
@Entity
@Table(name="tb_device_issue")
public class DeviceIssue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;//


	
	private String device;//设备id
	private String error_code;//错误代码
	private Integer error_count;//错误发生的次数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="GMT+8")
	private Date start_time;//开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="GMT+8")
	private Date end_time;//结束时间
	private String error_detail;//报警信息
	private String error_desc;//异常说明
	private String process;//处理过程
	private String person;//处理人员
	private String improvement;//改善对策
	private String type;//设备生产厂商

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevice() {		
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}

	public String getError_code() {		
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public Integer getError_count() {		
		return error_count;
	}
	public void setError_count(Integer error_count) {
		this.error_count = error_count;
	}

	public java.util.Date getStart_time() {		
		return start_time;
	}
	public void setStart_time(java.util.Date start_time) {
		this.start_time = start_time;
	}

	public java.util.Date getEnd_time() {		
		return end_time;
	}
	public void setEnd_time(java.util.Date end_time) {
		this.end_time = end_time;
	}

	public String getError_detail() {		
		return error_detail;
	}
	public void setError_detail(String error_detail) {
		this.error_detail = error_detail;
	}

	public String getError_desc() {		
		return error_desc;
	}
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}

	public String getProcess() {		
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}

	public String getPerson() {		
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}

	public String getImprovement() {		
		return improvement;
	}
	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
}
