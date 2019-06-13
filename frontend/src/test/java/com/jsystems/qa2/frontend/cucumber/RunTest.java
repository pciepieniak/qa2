package com.jsystems.qa2.frontend.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = "src/test/resources",
      glue = "classpath:com.jsystems.qa2.frontend.cucumber",
      plugin = {
              "html:target/cucumber-html-report",
              "rerun:target/return.txt"
      },
      tags = {
              "@notyfication",
//              "@wordpress",
//              "@login",
//              "@userProfile"
      }
)
public class RunTest {

}
