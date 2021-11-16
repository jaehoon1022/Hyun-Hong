package com.hhgg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hhgg.data.dto.SummonerDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<String> findSummonerName(String name);

    public SummonerDTO setDTO(ResponseEntity<String> responseEntity) throws JsonProcessingException;

    public ResponseEntity<String> findByEncryptId(String summonerId);


    }