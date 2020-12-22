package com.amhs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.amhs.pojo.DeviceIssue;
/**
 * -数据访问接口
 * @author Sun.chuanwang
 *
 */
public interface DeviceIssueDao extends JpaRepository<DeviceIssue,Integer>,JpaSpecificationExecutor<DeviceIssue>{
	
}
