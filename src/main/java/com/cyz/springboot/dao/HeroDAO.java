package com.cyz.springboot.dao;

import com.cyz.springboot.pojo.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroDAO extends JpaRepository<Hero,Integer> {
}
