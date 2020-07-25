package com.exampleTruLaLa.TruLaLa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerDelete {

    @RequestMapping("/{id7}")
    public   String methodGetForPost(
            @PathVariable (value = "id7") String id4,
            String id) throws Exception {

        System.out.println(id);
        System.out.println(id4);

        return "changeProduct";
    }



}
