package com.iclout.runner.roman.inter.impl;

import com.iclout.runner.roman.inter.Coach;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
//@Lazy
public class CricketCoach implements Coach {
    Logger logs = Logger.getLogger(CricketCoach.class.getName());
    public CricketCoach() {
        logs.info("The class name is "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "working out so fast";
    }
}

