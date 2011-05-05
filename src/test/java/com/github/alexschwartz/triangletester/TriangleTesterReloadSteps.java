package com.github.alexschwartz.triangletester;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.github.alexschwartz.triangletester.TriangleOracle.TriangleType;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;

public class TriangleTesterReloadSteps {
    
    TriangleType result;
    TriangleOracle oracle = new TriangleOracle();
  

    @Given("^the side length values (\\d+),\\s*(\\d+),\\s*(\\d+)$")
    public void theSideLengthValues(int side1, int side2, int side3) {
        this.result = this.oracle.analyze(side1, side2, side3);
    }

    @When("^ask the triangle type oracle is asked$")
    public void askTheTriangleTypeOracleIsAsked() {
    }

    @Then("^the triangle type is \"(.*)\"$")
    public void ensureTriangleTypeIs(String type) {
        assertThat(result.toString(), is(type));
    }


}
