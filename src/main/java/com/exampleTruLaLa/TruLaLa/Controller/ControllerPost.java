package com.exampleTruLaLa.TruLaLa.Controller;


import com.exampleTruLaLa.TruLaLa.Entity.*;
import com.exampleTruLaLa.TruLaLa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ControllerPost {
    private final RepositoryGoods repositoryGoods;
    private final RepositoryElectroinstrument repositoryElectroTools;
    private final StorageService storageService;
    private final RepositorySadGorod repositorySadGorod;
    private final RepositorySantehnica repositorySantehnica;
    private final RepositoryBudSum repositoryBudSum;
    private final RepositoryInstrument repositoryInstrument;
    @Autowired
    public ControllerPost(StorageService storageService,
                          RepositoryGoods repositoryGoods,
                          RepositoryElectroinstrument repositoryElectroTools,
                          RepositorySadGorod repositorySadGorod,
                          RepositorySantehnica repositorySantehnica,
                          RepositoryBudSum repositoryBudSum,
                          RepositoryInstrument repositoryInstrument) {
        this.storageService = storageService;
        this.repositoryGoods = repositoryGoods;
        this.repositoryElectroTools = repositoryElectroTools;
        this.repositorySadGorod = repositorySadGorod;
        this.repositorySantehnica = repositorySantehnica;
        this.repositoryBudSum = repositoryBudSum;
        this.repositoryInstrument = repositoryInstrument;
    }



    @GetMapping("/pos")
    public   String methodGetForPost( @RequestParam (defaultValue = "vsedlyaremontu")
                                      String category,
                                      Model model) throws Exception {



switch (category){
    case "santehnica":
    {
    model.addAttribute("electro",repositorySantehnica.findAll());
    return "index";
    }
    case "budsum":
    {
        model.addAttribute("electro",repositoryBudSum.findAll());
        return "index";
    }
    case "vsedlyaremontu":
    {
        model.addAttribute("electro",repositoryGoods.findAll());
        return "index";
    }
    default:model.addAttribute("electro", repositoryGoods.findAll());
    case "instrumenty":
    {
        model.addAttribute("electro",repositoryInstrument.findAll());
        return "index";
    }
    case "sadgorod":
    {
        model.addAttribute("electro",repositorySadGorod.findAll());
        return "index";
    }
    case "electroinstrumenty":
    {
        model.addAttribute("electro",repositoryElectroTools.findAll());
        return "index";
    }
}
//return "index";
    }

    @PostMapping("/post")

    public String methodPost(@RequestParam(defaultValue = "no name") String name,
                             @RequestParam(value = "price", defaultValue = "0.00f") Float price,
                             @RequestParam(value = "pidCategory", defaultValue = "instrument") String pidCategory,
                             @RequestParam(value = "description", defaultValue = "") String description,
                             @RequestParam(value = "category", defaultValue = "VseDlyaRemontu") String category,
                             @RequestParam MultipartFile file,Model model){
        System.out.println(description+" "+pidCategory);
        switch (category){
            case "VseDlyaRemontu" :{ Goods goods = new Goods();
                                     goods.setName(name);
                                     goods.setPrice(price);
                                     goods.setDescription(description);
                                     goods.setPidCategory(pidCategory);
                                 if(file.isEmpty()){
                                     goods.setImagePath("noImage.png");
                                     repositoryGoods.save(goods);
                                     model.addAttribute("electro", repositoryGoods.findAll());
                                     return "index";}
                                 else
                                     goods.setImagePath(file.getOriginalFilename());
                                     storageService.store(file);
                                     repositoryGoods.save(goods);
                                     model.addAttribute("electro", repositoryGoods.findAll());
                                     return "index";}
            case "Electroinstrument" :{ Electroinstrument electroinstrument = new Electroinstrument();
                                        electroinstrument.setName(name);
                                        electroinstrument.setDescription(description);
                                        electroinstrument.setPidCategory(pidCategory);
                                        electroinstrument.setPrice(price);
                                 if(file.isEmpty()){
                                        electroinstrument.setImagePath("noImage.png");
                                        repositoryElectroTools.save(electroinstrument);
                                        model.addAttribute("electro", repositoryElectroTools.findAll());
                                        return "index";}
                                 else
                                        electroinstrument.setImagePath(file.getOriginalFilename());
                                        storageService.store(file);
                                        repositoryElectroTools.save(electroinstrument);
                                        model.addAttribute("electro", repositoryElectroTools.findAll());
                                        return "index";}
            case "BudivelniSumish" :{   BudivelniSumish electroinstrument = new BudivelniSumish();
                                        electroinstrument.setName(name);
                                        electroinstrument.setName(name);
                                        electroinstrument.setDescription(description);
                                        electroinstrument.setPrice(price);
                                 if(file.isEmpty()){
                                        electroinstrument.setImagePath("noImage.png");
                                        repositoryBudSum.save(electroinstrument);
                                        model.addAttribute("electro", repositoryBudSum.findAll());
                                        return "index";}
                                 else
                                        electroinstrument.setImagePath(file.getOriginalFilename());
                                        storageService.store(file);
                                        repositoryBudSum.save(electroinstrument);
                                        model.addAttribute("electro", repositoryBudSum.findAll());
                                        return "index";}
            case "Santehnica" :{   Santehnika electroinstrument = new Santehnika();
                                        electroinstrument.setName(name);
                                        electroinstrument.setName(name);
                                        electroinstrument.setDescription(description);
                                        electroinstrument.setPrice(price);
                                 if(file.isEmpty()){
                                        electroinstrument.setImagePath("bol.jpeg");
                                        repositorySantehnica.save(electroinstrument);
                                        model.addAttribute("electro", repositorySantehnica.findAll());
                                        return "index";}
                                 else
                                        electroinstrument.setImagePath(file.getOriginalFilename());
                                        storageService.store(file);
                                        repositorySantehnica.save(electroinstrument);
                                        model.addAttribute("electro", repositorySantehnica.findAll());
                                        return "index";}

            case "Instrumenty" :{   Instrumenty electroinstrument = new Instrumenty();
                                        electroinstrument.setName(name);
                                        electroinstrument.setName(name);
                                        electroinstrument.setDescription(description);
                                        electroinstrument.setPrice(price);
                                if(file.isEmpty()){
                                        electroinstrument.setImagePath("noImage.png");
                                        repositoryInstrument.save(electroinstrument);
                                        model.addAttribute("electro", repositoryInstrument.findAll());
                                        return "index";}
                                else
                                        electroinstrument.setImagePath(file.getOriginalFilename());
                                        storageService.store(file);
                                        repositoryInstrument.save(electroinstrument);
                                        model.addAttribute("electro", repositoryInstrument.findAll());
                                        return "index";}

            case "SadGorod" :{   SadGorod electroinstrument = new SadGorod();
                                        electroinstrument.setName(name);
                                        electroinstrument.setName(name);
                                        electroinstrument.setDescription(description);
                                        electroinstrument.setPrice(price);
                               if(file.isEmpty()){
                                        electroinstrument.setImagePath("noImage.png");
                                        repositorySadGorod.save(electroinstrument);
                                        model.addAttribute("electro", repositorySadGorod.findAll());
                                        return "index";}
                               else
                                        electroinstrument.setImagePath(file.getOriginalFilename());
                                        storageService.store(file);
                                        repositorySadGorod.save(electroinstrument);
                                        model.addAttribute("electro", repositorySadGorod.findAll());
                                        return "index";}
        }

        return "index";
    }


}
