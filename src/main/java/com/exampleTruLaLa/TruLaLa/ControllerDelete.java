package com.exampleTruLaLa.TruLaLa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class ControllerDelete {

    private final RepositoryGoods repositoryGoods;

    private Goods product;

    public ControllerDelete(RepositoryGoods repositoryGoods) {
        this.repositoryGoods = repositoryGoods;
    }

    @RequestMapping("/{id7}")
    public   String methodGetForPost(
            @PathVariable (value = "id7") String id4,
            String id, Model model) throws Exception {

        System.out.println(id);
        System.out.println(id4);

        model.addAttribute("productToChange",repositoryGoods.getOne(Long.parseLong(id)));

        return "changeProduct";
    }



}
