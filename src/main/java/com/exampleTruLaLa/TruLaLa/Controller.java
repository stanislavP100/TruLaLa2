package com.exampleTruLaLa.TruLaLa;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping ("/")
  public   String cont()
    {
        return "index";
    }

}
