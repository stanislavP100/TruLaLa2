package com.exampleTruLaLa.TruLaLa.Controller;

import com.exampleTruLaLa.TruLaLa.Entity.*;
import com.exampleTruLaLa.TruLaLa.Repository.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class Controller {

private final RepositoryGoods repositoryGoods;
private final RepositoryElectroinstrument repositoryElektroTools;
private final RepositoryInstrument repositoryInstrument;
private final RepositorySantehnica repositorySantehnica;
private final RepositorySadGorod repositorySadGorod;
private final RepositoryBudSum repositoryBudSum;


    public Controller(RepositoryElectroinstrument repositoryElektroTools, RepositoryGoods repositoryGoods, RepositoryInstrument repositoryInstrument, RepositorySantehnica repositorySantehnica, RepositorySadGorod repositorySadGorod, RepositoryBudSum repositoryBudSum) {
        this.repositoryElektroTools = repositoryElektroTools;
        this.repositoryGoods = repositoryGoods;
        this.repositoryInstrument = repositoryInstrument;
        this.repositorySantehnica = repositorySantehnica;
        this.repositorySadGorod = repositorySadGorod;
        this.repositoryBudSum = repositoryBudSum;
    }


    @GetMapping (value = "/", produces = "text/plain;charset=UTF-8")
  public   String cont(@RequestParam (defaultValue = "vsedlyaremontu")
                                   String category)
    {

      switch (category) {
     /////////////////////////////////////////////////////////////////////////////////////
          case "vsedlyaremontu" : {//JSONObject mainJsonObject = new JSONObject();
          JSONArray sampleArr = new JSONArray();
          List<Goods> goodsList = repositoryGoods.findAll();


          for (Goods f : goodsList) {
              JSONObject jsonObject = new JSONObject();
              jsonObject.put("name", f.getName());
              jsonObject.put("price", f.getPrice());
              jsonObject.put("id", f.getId());
              jsonObject.put("image", f.getImagePath());
              jsonObject.put("description", f.getDescription());
              jsonObject.put("pidCategory", f.getPidCategory());

              sampleArr.put(jsonObject);
          }
        //  mainJsonObject.put("VseDlyaRemontu", sampleArr);


          return sampleArr.toString();

          }
////////////////////////////////////////////////////////////////////////////////////////////////
          case "electroinstrument" : {//JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArrE = new JSONArray();
              List<Electroinstrument> goodsList = repositoryElektroTools.findAll();


              for (Electroinstrument f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());
                  jsonObject.put("description", f.getDescription());
                  jsonObject.put("pidCategory", f.getPidCategory());

                  sampleArrE.put(jsonObject);
              }
           //   mainJsonObject.put("Electroinstrument", sampleArrE);

              return sampleArrE.toString();
          }
///////////////////////////////////////////////////////////////////////////
          case "sadgorod" : {JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArrSad = new JSONArray();
              List<SadGorod> goodsList = repositorySadGorod.findAll();


              for (SadGorod f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());
                  jsonObject.put("description", f.getDescription());
                  jsonObject.put("pidCategory", f.getPidCategory());

                  sampleArrSad.put(jsonObject);
              }
              mainJsonObject.put("SadGorod", sampleArrSad);

              return mainJsonObject.toString();
          }
////////////////////////////////////////////////////////////////////////////
          case "budsumishi" : {//JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArrB = new JSONArray();
              List<BudivelniSumish> goodsList = repositoryBudSum.findAll();


              for (BudivelniSumish f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());
                  jsonObject.put("description", f.getDescription());
                  jsonObject.put("pidCategory", f.getPidCategory());

                  sampleArrB.put(jsonObject);
              }
            //  mainJsonObject.put("BudivelniSumishi", sampleArrB);

              return sampleArrB.toString();
          }
  //////////////////////////////////////////////////////////////////////////////////////////////////////
          case "santehnica" : {//JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArrSan = new JSONArray();
              List<Santehnika> goodsList = repositorySantehnica.findAll();


              for (Santehnika f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());
                  jsonObject.put("description", f.getDescription());
                  jsonObject.put("pidCategory", f.getPidCategory());

                  sampleArrSan.put(jsonObject);
              }
             // mainJsonObject.put("Santehnica", sampleArrSan);

              return sampleArrSan.toString();
          }
//////////////////////////////////////////////////////////////////////////////////////////////////
          case "instrumenty" : {//JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArrI = new JSONArray();
              List<Instrumenty> goodsList = repositoryInstrument.findAll();


              for (Instrumenty f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());
                  jsonObject.put("description", f.getDescription());
                  jsonObject.put("pidCategory", f.getPidCategory());

                  sampleArrI.put(jsonObject);
              }
            //  mainJsonObject.put("Instrumenty", sampleArrI);

              return sampleArrI.toString();
          }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////
          default:
              return  "error55";
      }

    //  return "error55";

    }



    @GetMapping (value = "/retrofittest", produces = "text/plain;charset=UTF-8")
    public   String conte( HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");

        JSONObject mainJsonObject = new JSONObject();
        JSONArray sampleArr = new JSONArray();
        List<Goods> goodsList = repositoryGoods.findAll();


        for (Goods f : goodsList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", f.getName());
            jsonObject.put("price", f.getPrice());
            jsonObject.put("id", f.getId());
            jsonObject.put("image", f.getImagePath());
            jsonObject.put("description", f.getDescription());
            jsonObject.put("pidCategory", f.getPidCategory());

            sampleArr.put(jsonObject);
        }
    //    mainJsonObject.put("Instrumenty", sampleArr);

   //     System.out.println(sampleArr.toString());

      //  model.addAttribute("ooo", sampleArr.toString());
return sampleArr.toString();
     //   String ff=sampleArr.toString();
       // return "ИИИИИИИИИИИИИИИИИИИИИИИИИ";// sampleArr.toString();
//return "index2";
    }

}
