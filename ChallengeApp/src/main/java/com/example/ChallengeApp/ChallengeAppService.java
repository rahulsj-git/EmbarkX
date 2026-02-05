package com.example.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeAppService {

    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeAppService() {
        Challenge challenge1 = new Challenge(1L, "Jan", "Asiigned Challenge");
        challenges.add(challenge1);
    }

    public Challenge getChallenge(String months) {

        for (Challenge challenge : challenges) {
            if (challenge.getMonths().equalsIgnoreCase(months)) {
                return challenge;
            }

        }
        return null;

    }

    public List<Challenge> getallchallenge() {
        return challenges;
    }


    public boolean setallchallenge(Challenge challenge) {
        if (challenge.getId() != null) {
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }

    public boolean updatechallenge(Long id, Challenge challenge) {
        for (Challenge challenge2 : challenges) {
            if (challenge2.getId().equals(challenge.getId())) {
                challenge2.setMonths(challenge.getMonths());
                challenge2.setDescription(challenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenges(Long id) {
    return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}
