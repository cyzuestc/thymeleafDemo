package com.cyz.springboot.service;

import com.cyz.springboot.dao.HeroDAO;
import com.cyz.springboot.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {
    @Autowired
    HeroDAO heroDAO;

    public Hero add(Hero hero){
       return heroDAO.save(hero);
    }
    public void delete(int id){
        heroDAO.delete(id);
    }
    public void update(Hero hero){
        heroDAO.save(hero);
    }
    public Hero get(int id){
        return heroDAO.findOne(id);
    }
    public List<Hero> list(){
        return heroDAO.findAll();
    }
}
