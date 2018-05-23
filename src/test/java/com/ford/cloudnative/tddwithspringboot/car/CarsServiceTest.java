package com.ford.cloudnative.tddwithspringboot.car;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CarsServiceTest {

    private CarsService carsService;

    @Before
    public void setUp(){
        carsService = new CarsService();
    }

    @Test
    public void getCarDetails() {
        Car car = carsService.getCarDetials("prius");
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarsNotFoundException.class)
    public void getCarDetails_ReturnsNull_Not_Found() {
        carsService.getCarDetials("notfound");
    }
}
