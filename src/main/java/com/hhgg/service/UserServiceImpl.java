package com.hhgg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhgg.data.dto.LeagueEntryDTO;
import com.hhgg.data.dto.SummonerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private static final String API_KEY = "RGAPI-fbbd0d1e-dbac-4405-976d-2da608ac552a";

    private static final String API_URI = "https://kr.api.riotgames.com";
    private static final String SEARCH_BY_NAME = "/lol/summoner/v4/summoners/by-name/";
    private static final String SEARCH_BY_ID = "/lol/league/v4/entries/by-summoner/";


    // ------ 닉네임으로 summoner API 호출 ------
    @Override
    public ResponseEntity<String> findSummonerName(String summonerName) {
        URI uri = UriComponentsBuilder.fromUriString(API_URI)
                .path(SEARCH_BY_NAME + summonerName)
                .queryParam("api_key", API_KEY)
                .encode()
                .build()
                .toUri();

        // 외부(RIOT) API를 호출하기위해 Spring의 RestTemplate 채택
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(uri, String.class);
    }

    // ----- summoner API -> SummonerDTO에 담는 과정 ------
    @Override
    public SummonerDTO setDTO(ResponseEntity<String> responseEntity) throws JsonProcessingException {
        // jackson 라이브러리를 이용하여 json을 java 객체로 바꿔 DTO 객체에 담는 과정

       ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(responseEntity.getBody(), SummonerDTO.class);

    }

    // ----- Summoner Id로 League API 호출 -----
    @Override
    public ResponseEntity<String> findByEncryptId(String summonerId) {
        URI uri = UriComponentsBuilder.fromUriString(API_URI)
                .path(SEARCH_BY_ID + summonerId)
                .queryParam("api_key", API_KEY)
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(uri, String.class);
    }

    public LeagueEntryDTO setLeagueEntryDTO(ResponseEntity<String> responseEntity) {

        return null;
    }

}
