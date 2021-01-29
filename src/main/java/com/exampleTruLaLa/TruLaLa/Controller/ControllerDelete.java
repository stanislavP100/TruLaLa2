package com.exampleTruLaLa.TruLaLa.Controller;

import com.exampleTruLaLa.TruLaLa.Entity.*;
import com.exampleTruLaLa.TruLaLa.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ControllerDelete {

    private final RepositoryGoods repositoryGoods;
    private final RepositoryBudSum repositoryBudSum;
    private final RepositorySadGorod repositorySadGorod;
    private final RepositoryInstrument repositoryInstrument;
    private final RepositoryElectroinstrument repositoryElectroinstrument;
    private final RepositorySantehnica repositorySantehnica;

    private final StorageService storageService;

    private Goods product;
    private Santehnika santehnika;
    private SadGorod sadGorod;
    private Instrumenty instrumenty;
    private Electroinstrument electroinstrument;
    private BudivelniSumish budivelniSumish;

    private String category;

    public ControllerDelete(RepositoryGoods repositoryGoods,
                            RepositoryBudSum repositoryBudSum,
                            RepositorySadGorod repositorySadGorod,
                            RepositoryInstrument repositoryInstrument,
                            RepositoryElectroinstrument repositoryElectroinstrument,
                            RepositorySantehnica repositorySantehnica,
                            StorageService storageService) {
        this.repositoryGoods = repositoryGoods;
        this.repositoryBudSum = repositoryBudSum;
        this.repositorySadGorod = repositorySadGorod;
        this.repositoryInstrument = repositoryInstrument;
        this.repositoryElectroinstrument = repositoryElectroinstrument;
        this.repositorySantehnica = repositorySantehnica;
        this.storageService=storageService;
    }

    @RequestMapping("/{idForProduktToChange44}")
    /////////// Tyt nichogo ne deletity !!!!!!!!!!!!!!!!!!!!!!!!!!
    public   String methodGetForPost(    @PathVariable (value = "idForProduktToChange44") String id4,
            String idForProduktToChange44, Model model) throws Exception {

        ////////////////////////////////////////////////////////////////////////////////////
//         idForProduktToChange44 v index.html povynen buty takiy samiy line 80
/////////////////////////////////////////////////////////////////////////////////////////////////

        category=id4;

        switch (category){

            case "santehnika": {santehnika=repositorySantehnica.getOne(Long.parseLong(idForProduktToChange44));
                model.addAttribute("productToChange", santehnika);
                return "changeProduct";}

            case "budsumishi":{budivelniSumish=repositoryBudSum.getOne(Long.parseLong(idForProduktToChange44));
                model.addAttribute("productToChange", budivelniSumish);
                return "changeProduct";}

            case "electroinstrument":{electroinstrument=repositoryElectroinstrument.getOne(Long.parseLong(idForProduktToChange44));
                model.addAttribute("productToChange", electroinstrument);
                return "changeProduct";}

            case "instrument":{instrumenty=repositoryInstrument.getOne(Long.parseLong(idForProduktToChange44));
                model.addAttribute("productToChange", instrumenty);
                return "changeProduct";}

            case "sadgorod":{sadGorod=repositorySadGorod.getOne(Long.parseLong(idForProduktToChange44));
                model.addAttribute("productToChange", sadGorod);
                return "changeProduct";}

            case "goods":{product=repositoryGoods.getOne(Long.parseLong(idForProduktToChange44));
                model.addAttribute("productToChange", product);
                return "changeProduct";}

            default: return "index";

        }
    }

//    @GetMapping("/changeProducta")
//    public String getPage(){
//
//        return "changeProduct";
//    }

    @PostMapping("/changeProduct")

    public String changeProductPost(@RequestParam String name,
                                    @RequestParam(value = "price") Float price,
                                    @RequestParam MultipartFile file, Model model)
    {


        switch (category) {

            case "santehnika":{

                santehnika.setName(name);
                santehnika.setPrice(price);

                if (file.isEmpty()) {
                    System.out.println("Santeh file is empty!!!!!");
                    repositorySantehnica.save(santehnika);
                    model.addAttribute("electro", repositorySantehnica.findAll()); //storageService.loadAll());//.map(
                    return "index";
                }
                santehnika.setImagePath(file.getOriginalFilename());

                repositorySantehnica.save(santehnika);

                try {
                    storageService.store(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("electro", repositorySantehnica.findAll());
                return  "index";

            }

            case "budsumishi":{
                budivelniSumish.setName(name);

                budivelniSumish.setPrice(price);

                if (file.isEmpty()) {
                    repositoryBudSum.save(budivelniSumish);
                    model.addAttribute("electro", repositoryBudSum.findAll()); //storageService.loadAll());//.map(
                    return "index";
                }
                budivelniSumish.setImagePath(file.getOriginalFilename());

                repositoryBudSum.save(budivelniSumish);

                try {
                    storageService.store(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("electro", repositoryBudSum.findAll());
                return  "index";
            }

            case "electroinstrument":{
                electroinstrument.setName(name);

                electroinstrument.setPrice(price);

                if (file.isEmpty()) {

                    repositoryElectroinstrument.save(electroinstrument);
                    model.addAttribute("electro", repositoryElectroinstrument.findAll()); //storageService.loadAll());//.map(
                    return "index";
                }
                electroinstrument.setImagePath(file.getOriginalFilename());

                repositoryElectroinstrument.save(electroinstrument);

                try {
                    storageService.store(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("electro", repositoryElectroinstrument.findAll());
                return  "index";
            }

            case "instrument":{
                instrumenty.setName(name);

                instrumenty.setPrice(price);

                if (file.isEmpty()) {
                    repositoryInstrument.save(instrumenty);
                    model.addAttribute("electro", repositoryInstrument.findAll()); //storageService.loadAll());//.map(
                    return "index";
                }
                instrumenty.setImagePath(file.getOriginalFilename());

                repositoryInstrument.save(instrumenty);

                try {
                    storageService.store(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("electro", repositoryInstrument.findAll());
                return  "index";
            }

            case "sadgorod":{
                sadGorod.setName(name);

                sadGorod.setPrice(price);

                if (file.isEmpty()) {
                    repositorySadGorod.save(sadGorod);
                    model.addAttribute("electro",repositorySadGorod.findAll()); //storageService.loadAll());//.map(
                    return "index";
                }
                sadGorod.setImagePath(file.getOriginalFilename());

                repositorySadGorod.save(sadGorod);

                try {
                    storageService.store(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("electro", repositorySadGorod.findAll());
                return  "index";
            }

            case "goods": {
                product.setName(name);

                product.setPrice(price);

                if (file.isEmpty()) {
                    repositoryGoods.save(product);
                    model.addAttribute("electro", repositoryGoods.findAll()); //storageService.loadAll());//.map(
                    return "index";
                }
                product.setImagePath(file.getOriginalFilename());

                repositoryGoods.save(product);

                try {
                    storageService.store(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("electro", repositoryGoods.findAll());
                 return  "index";
            }

            default:{
                System.out.println(category+ "Default!!!!!!!!!");
                model.addAttribute("electro", repositoryGoods.findAll());
                return  "index";}
       }

    }

    @PostMapping("/deleteProduct")

    public String deleteProductPost(Model model){

        switch (category){

            case "santehnika" :{ repositorySantehnica.delete(santehnika);
                model.addAttribute("electro", repositorySantehnica.findAll());
            return "index";}

            case "goods" :{ repositoryGoods.delete(product);
                model.addAttribute("electro", repositoryGoods.findAll());
                return "index";}

            case "sadgorod" :{ repositorySadGorod.delete(sadGorod);
                model.addAttribute("electro", repositorySadGorod.findAll());
                return "index";}

            case "instrument" :{ repositoryInstrument.delete(instrumenty);
                model.addAttribute("electro", repositoryInstrument.findAll());
                return "index";}

            case "electroinstrument" :{ repositoryElectroinstrument.delete(electroinstrument);
                model.addAttribute("electro", repositoryElectroinstrument.findAll());
                return "index";}

            case "budsumishi" :{ repositoryBudSum.delete(budivelniSumish);
                model.addAttribute("electro", repositoryBudSum.findAll());
                return "index";}

        }

        repositoryGoods.delete(product);
        model.addAttribute("electro", repositoryGoods.findAll());

        return "index";
    }

}
