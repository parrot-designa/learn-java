package org.example.controller;

import org.apache.commons.io.IOUtils;
import org.example.entity.Dept;
import org.example.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeptController {

    public List<Dept> getDeptList(){
        // 获取部门流
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> strings = IOUtils.readLines(input,"utf-8");

        List<Dept> depts = strings.stream().map((str) -> {
            String[] paths = str.split("，");
            Integer id = Integer.valueOf(paths[0]);
            String name = paths[1];
            String updateTime = paths[2];
            return new Dept(id,name,updateTime);
        }).collect(Collectors.toList());

        return depts;
    }

//    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    @GetMapping("/dept")
    public Result getAll(){
        return Result.success(getDeptList());
    }
}
