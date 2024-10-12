package com.iclout.runner.roman.inter.impl;

import com.iclout.runner.roman.inter.Coach;

public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("in swimming constructor "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swiming thousan files";
    }
}
