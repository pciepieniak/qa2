package com.jsystems.qa2.qa2junit;

import org.junit.jupiter.api.*;

public class ConfigJunit {
    @BeforeAll
    public static void beforeAll(TestInfo testInfo)
    {
        // Przed wywolaniem metod
        System.out.println("-----------------------------------BEFORE-----------------------------------");
        System.out.println("Test class = " + testInfo.getTestClass().getClass().getSimpleName());
        System.out.println("Test name = " + testInfo.getDisplayName());
    }

    @AfterAll
    public static void afterAll(TestInfo testInfo)
    {
        // Po wszystkich metodach
        System.out.println("-----------------------------------AFTER-----------------------------------");
        System.out.println("Test class = " + testInfo.getTestClass().getClass().getSimpleName());
        System.out.println("Test name = " + testInfo.getDisplayName());
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo)
    {
        // Przed kazda jedna metoda
        System.out.println("-----------------------------------BEFORE EACH-----------------------------------");
        System.out.println("Test class = " + testInfo.getTestClass().getClass().getSimpleName());
        System.out.println("Test method = " + testInfo.getTestMethod());
        System.out.println("Test name = " + testInfo.getDisplayName());

    }


    @AfterEach
    public void afterEach(TestInfo testInfo)
    {
        // Po kazdej jednej metodzie
        System.out.println("-----------------------------------AFTER EACH-----------------------------------");
        System.out.println("Test class = " + testInfo.getTestClass().getClass().getSimpleName());
        System.out.println("Test method = " + testInfo.getTestMethod());
        System.out.println("Test name = " + testInfo.getDisplayName());
    }
}
