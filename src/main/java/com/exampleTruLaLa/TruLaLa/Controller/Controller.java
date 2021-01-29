package com.exampleTruLaLa.TruLaLa.Controller;

import com.exampleTruLaLa.TruLaLa.Entity.*;
import com.exampleTruLaLa.TruLaLa.Repository.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping ("/")
  public   String cont(@RequestParam (defaultValue = "vsedlyaremontu")
                                   String category)
    {

      switch (category) {
     /////////////////////////////////////////////////////////////////////////////////////
          case "vsedlyaremontu" : {JSONObject mainJsonObject = new JSONObject();
          JSONArray sampleArr = new JSONArray();
          List<Goods> goodsList = repositoryGoods.findAll();


          for (Goods f : goodsList) {
              JSONObject jsonObject = new JSONObject();
              jsonObject.put("name", f.getName());
              jsonObject.put("price", f.getPrice());
              jsonObject.put("id", f.getId());
              jsonObject.put("image", f.getImagePath());

              sampleArr.put(jsonObject);
          }
          mainJsonObject.put("VseDlyaRemontu", sampleArr);

          return mainJsonObject.toString();
      }
////////////////////////////////////////////////////////////////////////////////////////////////
          case "electroinstrument" : {JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArr = new JSONArray();
              List<Electroinstrument> goodsList = repositoryElektroTools.findAll();


              for (Electroinstrument f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());

                  sampleArr.put(jsonObject);
              }
              mainJsonObject.put("Electroinstrument", sampleArr);

              return mainJsonObject.toString();
          }
///////////////////////////////////////////////////////////////////////////
          case "sadgorod" : {JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArr = new JSONArray();
              List<SadGorod> goodsList = repositorySadGorod.findAll();


              for (SadGorod f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());

                  sampleArr.put(jsonObject);
              }
              mainJsonObject.put("SadGorod", sampleArr);

              return mainJsonObject.toString();
          }
////////////////////////////////////////////////////////////////////////////
          case "budsumishi" : {JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArr = new JSONArray();
              List<BudivelniSumish> goodsList = repositoryBudSum.findAll();


              for (BudivelniSumish f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());

                  sampleArr.put(jsonObject);
              }
              mainJsonObject.put("BudivelniSumishi", sampleArr);

              return mainJsonObject.toString();
          }
  //////////////////////////////////////////////////////////////////////////////////////////////////////
          case "santehnica" : {JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArr = new JSONArray();
              List<Santehnika> goodsList = repositorySantehnica.findAll();


              for (Santehnika f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());

                  sampleArr.put(jsonObject);
              }
              mainJsonObject.put("Santehnica", sampleArr);

              return mainJsonObject.toString();
          }
//////////////////////////////////////////////////////////////////////////////////////////////////
          case "instrumenty" : {JSONObject mainJsonObject = new JSONObject();
              JSONArray sampleArr = new JSONArray();
              List<Instrumenty> goodsList = repositoryInstrument.findAll();


              for (Instrumenty f : goodsList) {
                  JSONObject jsonObject = new JSONObject();
                  jsonObject.put("name", f.getName());
                  jsonObject.put("price", f.getPrice());
                  jsonObject.put("id", f.getId());
                  jsonObject.put("image", f.getImagePath());

                  sampleArr.put(jsonObject);
              }
              mainJsonObject.put("Instrumenty", sampleArr);

              return mainJsonObject.toString();
          }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////
          default: break;
      }

      return "error55";

    }




}