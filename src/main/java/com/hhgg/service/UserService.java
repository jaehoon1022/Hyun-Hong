package com.hhgg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hhgg.dto.EssentialDTO;
import com.hhgg.dto.SummonerDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    public ResponseEntity<String> findSummonerName(String name);

    public SummonerDTO setDTO(ResponseEntity<String> responseEntity) throws JsonProcessingException;

    public ResponseEntity<String> findEncryptId(String summonerId);

    public Map<String, Object> essentialData(String summonerName) throws JsonProcessingException;


    }