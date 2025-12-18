package org.example.controller;

import org.example.entity.Result;
import org.example.service.DepService;
import org.example.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DepService depService;

//    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    @GetMapping("/dept")
    public Result getAll(){
        return Result.success(depService.getList());
    }
}
