package com.jsystems.qa2.qa2junit;


import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit tests")
public class JunitTest {

    private final String str1 = "str1Test1";
    private final String str2 = "str1Test2";

    @Test
    @DisplayName("First junit test")
    @RepeatedTest(value = 5, name = "Repeated test")
     public void firstTest()
     {
         assertTrue(5 == 2 + 3, "Test message");
         assertFalse(false, "Test FALSE message");
         assertFalse(this.str1.matches("^s"));
         assertEquals("str1Test1", this.str1);
    //   assertNotNull(null);
         assertSame("str1Test1", this.str1);
      }

      @Test
      @DisplayName("Second junit test")
      @RepeatedTest(5)
      @Tag("Loop")
      public void secondTest()
      {
          assertThat(this.str1).isEqualTo("str1Test1");
          assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);

      }

      @Test
      @DisplayName("Array junit test")
      @Disabled("Waiting for bug fixing")
      public void arrayTest()
      {
          List<Integer> list1 = Arrays.asList(1,2,3,4,5);
          List<Integer> list2 = Arrays.asList(3,4,5);

          assertTrue(list1.containsAll(list2));
          assertThat(list1).hasSize(5);
          assertThat(list1).containsAnyOf(1,2,3,4,5,6,7,8);
      }

      @Nested
      @DisplayName("Nested Test class")
      public static class NestedSuiteClassTest
      {
          private final String str1 = "str1Test1";

          @Test
          @DisplayName("Nested class test")
          public void nestedTest()
          {
              assertThat(this.str1).isEqualTo("str1Test1");
          }
      }
}







//https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api