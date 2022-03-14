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
    void testWithDefaultJSON(){
        Exercise2.main(null);
    }

    @Test
    void testWithCustomJSON(){
        Exercise2.main(new String[]{"[{\"country\":\"US\",\"languages\":[\"en\",\"es\"]},{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},{\"country\":\"DE\",\"languages\":[\"de\"]},{\"country\":\"SU\",\"languages\":[\"de\",\"it\",\"fr\"]},{\"country\":\"ES\",\"languages\":[\"es\"]},{\"country\":\"PT\",\"languages\":[\"pt\"]},{\"country\":\"BR\",\"languages\":[\"pt\"]}]"});
    }
}
