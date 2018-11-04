package com.cyz.springboot.web;

import com.cyz.springboot.dao.CategoryDAO;
import com.cyz.springboot.dao.HeroDAO;
import com.cyz.springboot.pojo.Category;
import com.cyz.springboot.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    HeroDAO heroDAO;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        for (int i = 0; i < 100; i++) {
            Hero hero = new Hero();
            hero.setName("hero"+i);
            hero.setHp(6000+i);
            heroDAO.save(hero);
        }
        return "success";
    }

    @RequestMapping("/hello ")
    public String hello(Model model){
        model.addAttribute("name","thymeleaf");
        boolean b = true;
        model.addAttribute("testBoolean",b);
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        model.addAttribute("htmlContent",htmlContent);
        List<Category> list = new ArrayList<>();

        Date now = new Date();
        model.addAttribute("now",now);
        for (int i = 0; i < 10; i++) {
            Category c = new Category("category"+i);
            model.addAttribute("a"+i,c);
            list.add(c);
        }
        model.addAttribute("cs",list);
        return "category";

    }


    @RequestMapping("/listCategory")
    public String listCategory(Model m){
        List<Category> cs =categoryDAO.findAll();
        m.addAttribute("cs",cs);
        return "listCategory";
    }
}
