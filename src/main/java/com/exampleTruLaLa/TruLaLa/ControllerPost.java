package com.exampleTruLaLa.TruLaLa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerPost {

    @Autowired
    private RepositoryGoods repositoryGoods;

    @GetMapping("/post")
    public   String methodGetForPost() throws Exception {

        return "index";
    }

    @PostMapping("/post")

    public String methodPost(@RequestParam String name,
                             @RequestParam(value = "price") Float price){
        System.out.println(name+"    "+price);

        Goods goods=new Goods();

        goods.setName(name);

        goods.setPrice(price);



        repositoryGoods.save(goods);



        return "index";
    }
}
