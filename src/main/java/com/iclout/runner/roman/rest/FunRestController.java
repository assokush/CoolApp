package com.iclout.runner.roman.rest;

import com.iclout.runner.roman.inter.Coach;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class FunRestController {
    Logger logs = Logger.getLogger(FunRestController.class.getName());
    private final Coach thecoach;
    private final Coach thecoach2;

    private final Coach swimCoach;

    public FunRestController(Coach baseBallCoach, @Qualifier("baseBallCoach") Coach thecoach2, @Qualifier("aquatic") Coach swimCoach) {
        this.thecoach = baseBallCoach;
        this.thecoach2 = thecoach2;
        this.swimCoach = swimCoach;
    }

    @Autowired

    // expose "/" that return "Hello World"

    @GetMapping("/base")
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }



    @GetMapping("/workoutV2")
    public String getDailyAdded() {
        logs.info(String.format("Using %s class ", thecoach.getClass().getSimpleName()));
        return thecoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public  String compareBean(){
        System.out.println("Compareing bean thecoach == thecoach2, "+ (thecoach == thecoach2));
        return  "Compareing bean thecoach == thecoach2, "+ (thecoach == thecoach2);
    }
    @PreDestroy
    public void cleanUpConstruct(){
        logs.info(String.format("we are cleaning up the code working on it man %s", getClass().getSimpleName()));
    }
}






