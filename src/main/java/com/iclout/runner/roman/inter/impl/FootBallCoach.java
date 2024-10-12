package com.iclout.runner.roman.inter.impl;

import com.iclout.runner.roman.inter.Coach;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
//@Lazy
public class FootBallCoach implements Coach {
    Logger logs = Logger.getLogger(FootBallCoach.class.getName());
    public FootBallCoach() {
        logs.info("Class football name is "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "This is a football coach";
    }
}
