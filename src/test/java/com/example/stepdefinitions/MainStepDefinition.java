package com.example.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import java.net.MalformedURLException;

public class MainStepDefinition {

    @Given("{actor} try to go the main page")
    public void testerTryToGoTheMainPage(Actor actor) throws MalformedURLException {
        actor.attemptsTo(
                Task.where("{0} opens the main page selenium",
                        Open.url("https://selenium.dev")));
        System.out.println();
    }
}
