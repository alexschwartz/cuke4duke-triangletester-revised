package com.github.alexschwartz.triangletester;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.alexschwartz.triangletester.TriangleOracle.TriangleType;

import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;

public class TriangleTesterOrgSteps {
    
    TriangleType result;
    TriangleOracle oracle = new TriangleOracle();
  
    private int side1;
    private int side2;
    private int side3;


    @When("^I enter (\\d*[.]?\\d+) for side(\\d+)$")
    public void enterSideLength(int length, int sideNumber) {
        switch (sideNumber) {
          case 1: this.side1 = length; break;
          case 2: this.side2 = length; break;
          case 3: this.side3 = length; break;
        }
     
    }


    @Then("^triangle displays \"(.*)\" as the triangle type$")
    public void ensureTriangleTypeIs(String type) {
        this.result = this.oracle.analyze(side1, side2, side3);
        assertThat(result.toString(), is(type));
    }


}
