package com.visualnuts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.visualnuts.model.Country;

public class Exercise2 {
    private static final String DEFAULT_JSON = "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},{\"country\":\"DE\",\"languages\":[\"de\"]},{\"country\":\"ES\",\"languages\":[\"es\"]}]";

    public static void main(String[] args) {
        final String input = validateInput(args);
        final Country[] countries = validateJSONAndParseCountries(input);

        // Question 1
        totalCountries(countries);

        // Questions 2, 3, 4 and 5
        evaluateData(countries);
    }

    static int totalCountries(Country[] countries) {
        System.out.println("1 - There are " + countries.length + " countries in the world.");
        return countries.length;
    }

    private static void evaluateData(Country[] countries) {
        int countryWithMostLanguagesHavingDEIndex = -1;
        Set<String> spokenLanguages = new HashSet<>();
        int countryWithMostLanguagesIndex = -1;
        Map<String, Integer> languageOcurrences = new HashMap<>();

        for (int i = 0; i < countries.length; i++) {
            // Eval for question 2
            int languageLengthHavingDE = getLanguageLengthHavingDE(countries[i]);
            if (languageLengthHavingDE > 0) {
                try {
                    if (languageLengthHavingDE > countries[countryWithMostLanguagesHavingDEIndex].getLanguages().length) {
                        countryWithMostLanguagesHavingDEIndex = i;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // That's the first country which matches DE language
                    countryWithMostLanguagesHavingDEIndex = i;
                }
            }

            // Eval for question 3
            spokenLanguages.addAll(Arrays.asList(countries[i].getLanguages()));

            // Eval for question 4
            try {
                if (countries[i].getLanguages().length > countries[countryWithMostLanguagesIndex].getLanguages().length) {
                    countryWithMostLanguagesIndex = i;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // That's the first country
                countryWithMostLanguagesIndex = i;
            }


        }

        // Question 2
        if (countryWithMostLanguagesHavingDEIndex > -1) {
            System.out.println("2 - The country with the most official languages, where they officially speak German is "
                    + countries[countryWithMostLanguagesHavingDEIndex].getCountry() + ".");
        } else {
            System.out.println("2 - There are no countries where they officially speak German.");
        }

        // Question 3
        System.out.println("3 - There are " + spokenLanguages.size() + " official languages spoken in the listed countries.");

        // Question 4
        System.out.println("4 - The country with the most official languages is " + countries[countryWithMostLanguagesIndex].getCountry() + ".");
    }

    private static int getLanguageLengthHavingDE(Country country) {
        for (int j = 0; j < country.getLanguages().length; j++) {
            if (country.getLanguages()[j].equalsIgnoreCase("de")) {
                return country.getLanguages().length;
            }
        }
        return 0;
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
