package com.example.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private ChallengeAppService challengeAppService;

    public  ChallengeController(ChallengeAppService challengeAppService) {
        this.challengeAppService = challengeAppService;
    }

    @GetMapping
    public List<Challenge> getallchallenge(){
        return challengeAppService.getallchallenge();
    }

    @PostMapping
    public String setallchallenge(@RequestBody Challenge challenge){
        boolean isNewChallengeAdded = challengeAppService.setallchallenge(challenge);
        if (isNewChallengeAdded) {
            return "Challenges added successfully";
        } else {
            return "Challenges not added ";
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeAppService.getChallenge(month);
        if(challenge!=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping(("/{id}"))
    public ResponseEntity<String> updateChallenges(@PathVariable Long id,@RequestBody Challenge challenge){
        boolean isUpdateChallenges = challengeAppService.updatechallenge(id, challenge);
        if(isUpdateChallenges)
     return new ResponseEntity<>("challenge updated successfully", HttpStatus.OK);
    else
        return new ResponseEntity<>("challenge not updated ", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenges(@PathVariable Long id){
        boolean isUpdateChallenges = challengeAppService.deleteChallenges(id);
        if(isUpdateChallenges)
            return new ResponseEntity<>("challenge deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("challenge not deleted ", HttpStatus.NOT_FOUND);
    }



}
