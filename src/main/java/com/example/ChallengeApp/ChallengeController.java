package com.example.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {

    private List<Challenge> challenges = new ArrayList<>();

    public  ChallengeController() {
        Challenge challenge1 = new Challenge(1L,"12", "first challenge");
        challenges.add(challenge1);
    }

    @GetMapping("/challenges")
    public List<Challenge> getallchallenge(){
        return challenges;
    }

    @PostMapping("/challengesPost/{id}")
    public void setallchallenge(long id, String months, String desc){
        Challenge challenge1 = new Challenge(id, months, desc);
        challenges.add(challenge1);
    }

}
