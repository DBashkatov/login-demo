package com.login.AuthDemo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpecialitiesQuestionTypesDto {

    List<String> specialities = new ArrayList<>();

    List<String> questionTypes = new ArrayList<>();

}
