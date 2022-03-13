package com.visualnuts;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.visualnuts.model.Country;

public class Exercise2 {
    private static final String DEFAULT_JSON = "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},{\"country\":\"DE\",\"languages\":[\"de\"]},{\"country\":\"ES\",\"languages\":[\"es\"]}]";

    public static void main(String[] args) {
        final String input = validateInput(args);
        final Country[] countries = validateJSONAndParseCountries(input);

    }

    private static String validateInput(String[] args) {
        String input = DEFAULT_JSON;
        if (args.length > 0) {
            if (args[0] == null) {
                throw new IllegalArgumentException("Null argument not allowed.");
            }
            input = args[0];
        }
        return input;
    }

    private static Country[] validateJSONAndParseCountries(String input) {
        try {
            Gson gson = new Gson();
            Country[] countries = gson.fromJson(input, Country[].class);
            if (countries == null || countries.length == 0) {
                throw new IllegalArgumentException("No countries found.");
            }
            for (Country country: countries) {
                if(country.getCountry() == null || country.getLanguages() == null || country.getLanguages().length == 0) {
                    throw new IllegalArgumentException("Invalid format of input data.");
                }
            }
            return countries;
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
