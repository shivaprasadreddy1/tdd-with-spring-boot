package com.ford.cloudnative.tddwithspringboot.car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarsService carsService;

    @Test
    public void getCar_ReturnsCar() throws Exception {
        Car car = new Car();
        car.setName("prius");
        car.setType("hybrid");

        Mockito.doReturn(car).when(carsService).getCarDetials("prius");

        this.mockMvc.perform(get("/cars/{name}", "prius"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("prius"))
                .andExpect(jsonPath("type").value("hybrid"));
    }

    @Test
    public void getCar_Returns_NotFound() throws Exception {
        Mockito.doReturn(null).when(carsService).getCarDetials("not-found");

        this.mockMvc.perform(get("/cars/{name}", "not-found")).andExpect(status().isNotFound());
    }
}
