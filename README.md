# exercises
Visual Nuts exercises

- Exercise 1 at module exercise1:
    An algorithm that prints the whole integer numbers to the console, start * from the number 1,
    and print all numbers going up to the number 100.
    
    However, when the number is divisible by 3, do not print the number, but print the word * 'Visual'.
    If the number is divisible by 5, do not print the number, but print 'Nuts'.
    And for all numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.

- Exercise 2 at module exercise2:
    Image you have a set of data in JSON, describing official languages spoken by countries, as such:
    [
        {
            country: "US",
            languages: [ "en" ]
        },
        {
            country: "BE",
            languages: [ "nl", "fr", "de" ]
        },
        {
            country: "NL",
            languages: [ "nl", "fy" ]
        },
        {
            country: "DE",
            languages: [ "de" ]
        },
        {
            country: "ES",
            languages: [ "es" ]
        }
    ]
    This module has a main function in Java that:
    1 - Returns the number of countries in the world
    2 - Finds the country with the most official languages, where they officially speak German (de).
    3 - Counts all the official languages spoken in the listed countries.
    4 - Find the country with the highest number of official languages.
    5 - Find the most common official language(s), of all countries.
    
In order to build the project and generate its jars, please run "mvn clean install".