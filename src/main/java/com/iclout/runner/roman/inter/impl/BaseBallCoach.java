package com.iclout.runner.roman.inter.impl;

import com.iclout.runner.roman.inter.Coach;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseBallCoach implements Coach {
    Logger logs = Logger.getLogger(BaseBallCoach.class.getName());
    public BaseBallCoach() {
        logs.info("the base ball is: "+ getClass().getSimpleName());
    }

  //  @PostConstruct
    public void aftercontruct(){
        logs.info(String.format("In post construct  %s", getClass().getSimpleName()));
    }
    @Override
    public String getDailyWorkout() {
        return "This is base ball coach";
    }

  //  @PreDestroy
    public void cleanUpConstruct(){
        logs.info(String.format("we are cleaning up the code working on it man %s", getClass().getSimpleName()));
    }
}
