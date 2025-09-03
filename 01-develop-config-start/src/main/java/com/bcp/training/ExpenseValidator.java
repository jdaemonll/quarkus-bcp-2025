package com.bcp.training;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExpenseValidator {
  @Inject
  ExpenseConfiguration config;

//  @ConfigProperty(name="debug-enabled", defaultValue = "false")
//  private boolean debugEnabled;
//
//  @ConfigProperty(name="range-high")
//  private int rangeHigh;
//
//  @ConfigProperty(name="range-low")
//  int targetRangeLow;


    public void debugRanges() {
        //System.out.println("Range - High: " + config.rangeHigh());
        //System.out.println("Range - Low: " + config.rangeLow());

      config.debugMessage().ifPresent(System.out::println);
    }

    public boolean isValidAmount(int amount) {
        if (config.debugEnabled()) {
            debugRanges();
        }

        return amount >= config.rangeLow() && amount <= config.rangeHigh();
    }
}
