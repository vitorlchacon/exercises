package com.visualnuts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.visualnuts.model.Country;

class Exercise2Test {

    @Test
    void shouldFailNullJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { null }));
        assertEquals("Null argument not allowed.", e.getMessage());
    }

    @Test
    void shouldFailEmptyJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { "" }));
        assertEquals("No countries found.", e.getMessage());
    }

    @Test
    void shouldFailEmptyListJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { "[]" }));
        assertEquals("No countries found.", e.getMessage());
    }

    @Test
    void shouldFailWrongInputJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { "[{\"abc\":\"US\",\"abc\":[\"en\"]}]" }));
        assertEquals("Invalid format of input data.", e.getMessage());
    }

    @Test
    void shouldFailMissingLanguagesJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { "[{\"country\":\"US\",\"languages\":[2]}, {\"country\":\"US\",\"abc\":[\"en\"]}]" }));
        assertEquals("Invalid format of input data.", e.getMessage());
    }

    @Test
    void shouldFailMissingCountryJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"abc\":\"US\",\"languages\":[\"en\"]}]" }));
        assertEquals("Invalid format of input data.", e.getMessage());
    }

    @Test
    void shouldFailCountryWithoutLanguagesJSONParsing(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Exercise2.main(new String[] { "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"abc\":\"US\",\"languages\":[]}]" }));
        assertEquals("Invalid format of input data.", e.getMessage());
    }

    @Test
    void shouldHave5Countries(){
        int totalCountries = Exercise2.totalCountries(new Country[] {
                new Country("US", new String[] { "en" }),
                new Country("BE", new String[] { "nl", "fr", "de" }),
                new Country("NL", new String[] { "nl", "fy" }),
                new Country("DE", new String[] { "de" }),
                new Country("ES", new String[] { "es" }),
        });
        assertEquals(5, totalCountries);
    }

}
