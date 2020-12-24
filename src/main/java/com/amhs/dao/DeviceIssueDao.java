package com.amhs.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.amhs.pojo.DeviceIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * -数据访问接口
 * @author Sun.chuanwang
 *
 */
public interface DeviceIssueDao extends JpaRepository<DeviceIssue,Integer>,JpaSpecificationExecutor<DeviceIssue>{
    @Query(value = "SELECT MAX(error_count) FROM tb_device_issue where device=?1 AND error_code=?2",nativeQuery = true)
    Integer findMaxCount(@Param(value = "device") String device, @Param(value = "error_code") String error_code);

    @Query(value = "SELECT * FROM tb_device_issue ORDER BY start_time DESC ",nativeQuery = true)
    Page<DeviceIssue> findPage(Pageable pageable);

    //查询昨天的记录
    @Query(value = "SELECT * FROM tb_device_issue WHERE DATE_FORMAT(start_time,'%Y-%m-%d')= DATE_FORMAT(ADDDATE(NOW(),-1),'%Y-%m-%d')",nativeQuery = true)
    List<DeviceIssue> yestoday();

    //本周的记录
    @Query(value = "SELECT * FROM tb_device_issue WHERE WEEK(start_time)=WEEK(NOW())",nativeQuery = true)
    List<DeviceIssue> thisWeek();

    //上周的记录
    @Query(value = "SELECT * FROM tb_device_issue WHERE YEARWEEK(DATE_FORMAT(start_time,'%Y-%m-%d'))=YEARWEEK(NOW())-1",nativeQuery = true)
    List<DeviceIssue> preWeek();

    //本月的记录
    @Query(value = "SELECT * FROM tb_device_issue WHERE MONTH(start_time)=MONTH(NOW())",nativeQuery = true)
    List<DeviceIssue> thisMonth();

}
