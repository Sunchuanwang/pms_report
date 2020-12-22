package com.amhs.controller;

import com.amhs.pojo.DeviceIssue;
import com.amhs.service.DeviceIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Sun.chuanwang
 * @version 1.0.0
 * @date 2020/12/20 1:34
 */
@Controller
public class Portal {
    @Autowired
    private DeviceIssueService deviceIssueService;

    @RequestMapping("test")
    public String portal(Model model){
        List<DeviceIssue> list = deviceIssueService.findAll();
        model.addAttribute("list",list);
        return "portal";
    }

}
