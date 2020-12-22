package com.amhs.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		PageRequest pageRequest = PageRequest.of(page-1, size, Sort.by(Sort.Direction.DESC,"id"));

		return deviceIssueDao.findAll(pageRequest);
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
                // 报警信息
                if (searchMap.get("error_detail")!=null && !"".equals(searchMap.get("error_detail"))) {
                	predicateList.add(cb.like(root.get("error_detail").as(String.class), "%"+(String)searchMap.get("error_detail")+"%"));
                }
                // 异常说明
                if (searchMap.get("error_desc")!=null && !"".equals(searchMap.get("error_desc"))) {
                	predicateList.add(cb.like(root.get("error_desc").as(String.class), "%"+(String)searchMap.get("error_desc")+"%"));
                }
                // 处理过程
                if (searchMap.get("process")!=null && !"".equals(searchMap.get("process"))) {
                	predicateList.add(cb.like(root.get("process").as(String.class), "%"+(String)searchMap.get("process")+"%"));
                }
                // 处理人员
                if (searchMap.get("person")!=null && !"".equals(searchMap.get("person"))) {
                	predicateList.add(cb.like(root.get("person").as(String.class), "%"+(String)searchMap.get("person")+"%"));
                }
                // 改善对策
                if (searchMap.get("improvement")!=null && !"".equals(searchMap.get("improvement"))) {
                	predicateList.add(cb.like(root.get("improvement").as(String.class), "%"+(String)searchMap.get("improvement")+"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
                
            }
        };		
		
	}

	public Page<DeviceIssue> findSearch(Map whereMap, int page, int size) {
		Specification<DeviceIssue> specification = where(whereMap);
		PageRequest pageRequest = PageRequest.of(page-1, size);
		return deviceIssueDao.findAll(specification, pageRequest);
	}

	public DeviceIssue findOne(Integer id) {

		return deviceIssueDao.findById(id).get();
	}

	@Transactional
	public void add(DeviceIssue deviceIssue) {
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

}
