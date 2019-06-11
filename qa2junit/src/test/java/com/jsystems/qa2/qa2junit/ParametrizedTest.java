package com.jsystems.qa2.qa2junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parametrized tests")
public class ParametrizedTest extends ConfigJunit{

    @ParameterizedTest(name = "Result for a test 1 with argument = {0}")
    @DisplayName("First test with parametr")
    @ValueSource(ints = {5, 15, 25})
    public void paramFirstTest (int number)
    {

        assertTrue(number % 5 == 0);
    }

    @ParameterizedTest(name = "Result for a test 2 with argument = {0}")
    @DisplayName("Second test with parametr")
    @ValueSource(strings = {"Hello", "Hello Junit", "Hello students"})
    public void paramSecondTest (String value)
    {
        assertTrue(value.contains("Hello"));
    }

    @DisplayName("CSV value parametrized test")
    @ParameterizedTest(name = "Parametrized test with values name {0} and value {1}")
    @CsvSource(value =  {"Hello, 5", "HelloJunit 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2)
    {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

    @DisplayName("CSV file parametrized test")
    @ParameterizedTest(name = "Parametrized test with data from csv file,  name {0} and value {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
    public void csvFileSourceTest(String param1, int param2)
    {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }
}
