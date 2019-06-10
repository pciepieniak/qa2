package com.jsystems.qa2.qa2junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parametrized tests")
public class ParametrizedTest {

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
}
