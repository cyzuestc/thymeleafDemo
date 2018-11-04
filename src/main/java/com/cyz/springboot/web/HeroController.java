package com.cyz.springboot.web;

import com.cyz.springboot.pojo.Hero;
import com.cyz.springboot.service.HeroService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {
    @Autowired
    HeroService heroService;
    @PutMapping
    public String update(@RequestBody Hero h){
        heroService.update(h);
        return "success";
    }
    @DeleteMapping("/heroes/{id}")
    public String delete(Hero h){
        heroService.delete(h.getId());
        return "success";
    }

    @PostMapping("/heroes")
    public String add(@RequestBody Hero h){
        heroService.add(h);
        return "success";
    }
    @GetMapping("/heroes")
    public PageInfo<Hero> list(@RequestParam(value = "start",defaultValue = "1")int start,
                               @RequestParam(value = "size",defaultValue = "10")int size){
        PageHelper.startPage(start,size,"id desc");
        List<Hero> hs = heroService.list();
        System.out.println(hs.size());

        PageInfo<Hero> page = new PageInfo<>(hs,10);
        return page;
    }
}
