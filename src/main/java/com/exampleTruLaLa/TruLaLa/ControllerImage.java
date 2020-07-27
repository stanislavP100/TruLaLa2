package com.exampleTruLaLa.TruLaLa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerImage {

    @Autowired
    private RepositoryGoods repositoryGoods;

    private  String imagePath;


    @GetMapping("/image")

    public   String methodGetForImage(Model model) throws Exception {

        model.addAttribute("imagePath", imagePath);

        return "getImage";
    }

 @RequestMapping("/image/{img}")
    public String methodGetFo(
             @PathVariable(value = "img") String image4,
            String img, Model model) throws Exception {


imagePath=img;

        model.addAttribute("imagePath", img);

        return "redirect:/image";
    }


}
