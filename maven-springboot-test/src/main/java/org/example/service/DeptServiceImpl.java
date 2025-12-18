package org.example.service;

import org.example.dao.DeptDao;
import org.example.dao.DeptDaoImpl;
import org.example.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class DeptServiceImpl implements DepService {
    @Autowired
    private DeptDao deptDao;

    public  List<Dept> getList(){
        List<String> strings = deptDao.getDeptString();
        List<Dept> depts = strings.stream().map((str) -> {
            String[] paths = str.split("，");
            Integer id = Integer.valueOf(paths[0]);
            String name = paths[1];
            String updateTime = paths[2];
            return new Dept(id,name,updateTime);
        }).collect(Collectors.toList());
        return depts;
    }
}
