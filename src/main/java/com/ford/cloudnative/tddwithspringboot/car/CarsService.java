package com.ford.cloudnative.tddwithspringboot.car;

import org.springframework.stereotype.Service;

@Service
public class CarsService {

    public Car getCarDetials(String name) {
        if(!name.equals("prius")){
            throw new CarsNotFoundException();
        }

        Car car = new Car();
        car.setName("prius");
        car.setType("hybrid");
        return car;
    }
}
