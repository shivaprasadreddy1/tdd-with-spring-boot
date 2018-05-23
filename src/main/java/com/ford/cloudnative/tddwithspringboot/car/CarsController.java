package com.ford.cloudnative.tddwithspringboot.car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {


    private CarsService carService;

    public CarsController(CarsService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    public Car getCar(@PathVariable String name){
        Car car = carService.getCarDetials(name);
        if(car==null){
            throw new CarsNotFoundException();
        }
        return car;
    }

}
