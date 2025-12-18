package org.example.service;

import org.example.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DeptServiceImpl2 implements DepService{
    public List<Dept> getList(){
        return Collections.singletonList(new Dept());
    }
}
