package com.amhs.controller;
import java.util.List;
import java.util.Map;

import com.amhs.pojo.PageResult;
import com.amhs.pojo.Result;
import com.amhs.pojo.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.amhs.pojo.DeviceIssue;
import com.amhs.service.DeviceIssueService;
/**
 * -控制器类
 * @author Sun.chuanwang
 *
 */
@Controller
@ResponseBody
@RequestMapping("/deviceIssue")
public class DeviceIssueController {

	@Autowired
	private DeviceIssueService deviceIssueService;

    @RequestMapping("/index")
	public String index(Model model){
        //List<DeviceIssue> deviceIssues = deviceIssueService.findAll();
        DeviceIssue deviceIssue = deviceIssueService.findOne(1);
        model.addAttribute("deviceIssue",deviceIssue);
	    return "portal";
    }
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<DeviceIssue> findAll(){			
		return deviceIssueService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page",defaultValue = "1") int page,@RequestParam(value = "rows",defaultValue = "20") int rows){
		Page<DeviceIssue> page_deviceIssue = deviceIssueService.findPage(page, rows);		
		return new PageResult<DeviceIssue>(page_deviceIssue.getTotalElements(), page_deviceIssue.getContent());
	}
	
	/**
	 * 增加
	 * @param deviceIssue
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result add(@RequestBody DeviceIssue deviceIssue){
		deviceIssueService.add(deviceIssue);
		return new Result(ResultCode.SUCCESS);
	}
	
	/**
	 * 修改
	 * @param deviceIssue
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody DeviceIssue deviceIssue){	
		deviceIssueService.update(deviceIssue);
		return new Result(true,10, "修改成功");
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public DeviceIssue findOne(Integer id){
		return deviceIssueService.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
	public Result delete(Integer [] ids){
		
		deviceIssueService.deleteList(ids);
		return new Result(ResultCode.SUCCESS);
		
	}

    @RequestMapping("/deleteOne")
    public Result delete(Integer id){

        deviceIssueService.delete(id);
        return new Result(ResultCode.SUCCESS);

    }
	
	/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public PageResult search(@RequestBody Map whereMap,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "20") int rows  ){
		Page<DeviceIssue> page_deviceIssue = deviceIssueService.findSearch(whereMap, page, rows);
		return new PageResult<DeviceIssue>(page_deviceIssue.getTotalElements(), page_deviceIssue.getContent());
	}


	
}
