package com.ford.cloudnative.tddwithspringboot.car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarsNotFoundException extends RuntimeException{
}
