package org.example.controller;

import org.example.entity.Result;
import org.example.service.DeptServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

//    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    @GetMapping("/dept")
    public Result getAll(){
        return Result.success(DeptServiceImpl.getList());
    }
}
