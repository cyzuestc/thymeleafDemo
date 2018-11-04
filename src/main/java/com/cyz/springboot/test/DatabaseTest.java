package com.cyz.springboot.test;

import com.cyz.springboot.dao.HeroDAO;
import com.cyz.springboot.pojo.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseTest {
    @Autowired
    HeroDAO heroDAO;
    @Test
    public void test(){

    }
}
