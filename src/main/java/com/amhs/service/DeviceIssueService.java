package com.amhs.service;
import java.util.*;
import javax.persistence.criteria.*;

import com.amhs.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.amhs.dao.DeviceIssueDao;
import com.amhs.pojo.DeviceIssue;
import org.springframework.transaction.annotation.Transactional;

/**
 * -业务逻辑类
 * @author Sun.chuanwang
 *
 */
@Service
public class DeviceIssueService {

	@Autowired
	private DeviceIssueDao deviceIssueDao;




    /**
     * 查询所有
     */
	public List<DeviceIssue> findAll() {
        //Sort sort= Sort.by(Sort.Order.desc("start_time"));

		return deviceIssueDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<DeviceIssue> findPage(int page, int size) {
	    Pageable pageable = PageRequest.of(page-1,size);
        return deviceIssueDao.findPage(pageable);
	}

	private Specification<DeviceIssue> where(Map searchMap) {
		
		return new Specification<DeviceIssue>() {
          
            @Override
			public Predicate toPredicate(Root<DeviceIssue> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 设备id
                if (searchMap.get("device")!=null && !"".equals(searchMap.get("device"))) {
                	predicateList.add(cb.equal(root.get("device").as(String.class), (String)searchMap.get("device")));
                }
                // 设备厂商
                if (searchMap.get("type")!=null && !"".equals(searchMap.get("type"))) {
                    predicateList.add(cb.equal(root.get("type").as(String.class), (String)searchMap.get("type")));
                }
                // 错误代码
                if (searchMap.get("error_code")!=null && !"".equals(searchMap.get("error_code"))) {
                	predicateList.add(cb.equal(root.get("error_code").as(String.class), (String)searchMap.get("error_code")));
                }
                //时间段查询
                if (searchMap.get("start_time")!=null && !"".equals(searchMap.get("start_time"))){
                    /*Date start_time = (Date) searchMap.get("start_time");*/
                    Date start_time = DateFormat.dateToString((String)searchMap.get("start_time"));

                    Date end_time = searchMap.get("end_time")==null ? new Date() : DateFormat.dateToString((String)searchMap.get("end_time"));
                    predicateList.add(cb.between(root.get("start_time").as(Date.class),start_time,end_time));
                }



                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<DeviceIssue> findSearch(Map whereMap, int page, int size) {
		Specification<DeviceIssue> specification = where(whereMap);
		PageRequest pageRequest = PageRequest.of(page-1, size, Sort.Direction.DESC,"id");
		return deviceIssueDao.findAll(specification, pageRequest);
	}

	public DeviceIssue findOne(Integer id) {

		return deviceIssueDao.findById(id).get();
	}

	@Transactional
	public void add(DeviceIssue deviceIssue) {
        Integer maxCount = deviceIssueDao.findMaxCount(deviceIssue.getDevice(), deviceIssue.getError_code());
        deviceIssue.setError_count(maxCount==null ? 1:maxCount+1);
        deviceIssueDao.save(deviceIssue);
	}
	
	public void update(DeviceIssue deviceIssue) {
		deviceIssueDao.save(deviceIssue);
	}

	public void delete(Integer id) {
		deviceIssueDao.deleteById(id);
	}

	public void deleteList(Integer[] ids) {
		for (Integer id : ids) {
			deviceIssueDao.deleteById(id);
		}
	}

	//昨天的记录
	public List<DeviceIssue> yestoday(){
	    return deviceIssueDao.yestoday();
    }
    //本周的记录
    public List<DeviceIssue> thisWeek(){
        return deviceIssueDao.thisWeek();
    }

    //上周的记录
    public List<DeviceIssue> preWeek(){
        return deviceIssueDao.preWeek();
    }
    //本月的记录
    public List<DeviceIssue> thisMonth(){
        return deviceIssueDao.thisMonth();
    }

}
