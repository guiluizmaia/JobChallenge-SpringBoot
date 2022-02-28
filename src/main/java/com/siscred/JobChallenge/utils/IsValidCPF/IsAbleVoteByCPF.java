package com.siscred.JobChallenge.utils.IsValidCPF;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IsAbleVoteByCPF implements IIsAbleVoteByCPF {

    @Override
    public Boolean isAbleVoteByCPF(String cpf) {
        String url = "https://user-info.herokuapp.com/users/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<isAbleCpf> isValid = restTemplate.getForEntity(url, isAbleCpf.class);
        if(isValid.getStatusCode() == HttpStatus.NOT_FOUND){
            return false;
        }else if(isValid.getBody().getStatus().equals("UNABLE_TO_VOTE"){
            return false;
        }
        return true;
    }
    
}
