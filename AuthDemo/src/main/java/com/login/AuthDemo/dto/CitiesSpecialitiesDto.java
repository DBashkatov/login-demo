package com.login.AuthDemo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CitiesSpecialitiesDto {

    List<String> cities = new ArrayList<>();

    List<String> sources = new ArrayList<>();

}
