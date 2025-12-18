package org.example.dao;

import org.apache.commons.io.IOUtils;
import org.example.entity.Dept;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class DeptDao {
    public List<String> getDeptString(){
        // 获取部门流
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> strings = IOUtils.readLines(input,"utf-8");

        return strings;
    }
}
