package com.botko3.ramen.Controller;
import com.botko3.ramen.Model.RamenShopProjection;
import com.botko3.ramen.Repo.RamenShopRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Random;

@Tag(name="Ramen Shops")
@RequestMapping("/")
@RestController
public class RamenController {

    @Autowired
    private RamenShopRepo ramenShopRepo;

    public String hello(){
        return "hello";
    }


    @GetMapping("/all")
    @Operation(summary = "All Ramen Shops in Hong Kong")
    public List<RamenShopProjection> getAll(){
        return ramenShopRepo.findByAll();
    }



    //pickbypriceandarea
    @GetMapping("/search")
    @Operation(summary = "Search by price and area")
    public List<RamenShopProjection> getByPriceAndArea(@RequestParam(value = "value",required = false) Integer value,@RequestParam(value = "area",required = false) String area ) {
        try{


            if(value < 0){
                throw new IllegalArgumentException("Budget can not be negative,bro");
            }



            if(value != null && area != null){
                return ramenShopRepo.findByPriceAndArea(value,area);
            } else if (value != null) {
                return ramenShopRepo.findItemsByValueRange(value);
            }else if (area != null){
                return ramenShopRepo.findByAreaIgnoreCaseContaining(area);
            }else{
                return null;
            }


        }catch(ClassCastException ex){
            throw new ClassCastException("Value input must be INTEGER");
        }



    }

    @GetMapping("/pickabowl")
    @Operation(summary = "Pick a random ramen shop for your next bowl")
    public List<RamenShopProjection> getOneRandom(){
        Random random = new Random();
        Integer num = random.nextInt(250);
        return ramenShopRepo.findByItemID(num);


    }







}
