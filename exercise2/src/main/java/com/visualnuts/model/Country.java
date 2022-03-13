package com.visualnuts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Country {
    String country;
    String[] languages;
}
