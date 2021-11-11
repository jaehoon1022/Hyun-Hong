package com.hhgg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhgg.dto.EssentialDTO;
import com.hhgg.dto.LeagueEntryDTO;
import com.hhgg.dto.SummonerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class UserServiceImpl implements UserService{

    private static final String API_KEY = "RGAPI-fbbd0d1e-dbac-4405-976d-2da608ac552a";

    private static final String API_URI = "https://kr.api.riotgames.com";
    private static final String SEARCH_BY_NAME = "/lol/summoner/v4/summoners/by-name/";
    private static final String SEARCH_BY_ID = "/lol/league/v4/entries/by-summoner/";

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private SummonerDTO summonerDTO = new SummonerDTO();


    @Override
    public ResponseEntity<String> findSummonerName(String summonerName) {
        URI uri = UriComponentsBuilder.fromUriString(API_URI)
                .path(SEARCH_BY_NAME + summonerName)
                .queryParam("api_key", API_KEY)
                .encode()
                .build()
                .toUri();

        // 외부(RIOT) API를 호출하기위해 Spring의 RestTemplate 채택
        return restTemplate.getForEntity(uri, String.class);
    }

    @Override
    public SummonerDTO setDTO(ResponseEntity<String> responseEntity) throws JsonProcessingException {
        // jackson 라이브러리를 이용하여 json을 java 객체로 바꿔 DTO 객체에 담는 과정

        return objectMapper.readValue(responseEntity.getBody(), SummonerDTO.class);

    }

    @Override
    public ResponseEntity<String> findEncryptId(String summonerId) {
        URI uri = UriComponentsBuilder.fromUriString(API_URI)
                .path(SEARCH_BY_ID + summonerId)
                .queryParam("api_key", API_KEY)
                .encode()
                .build()
                .toUri();

        return restTemplate.getForEntity(uri, String.class);
    }

    @Override
    public Map<String, Object> essentialData(String summonerName) throws JsonProcessingException {

        Map<String, Object> maps = new HashMap<>();
        ResponseEntity<String> responseName = findSummonerName(summonerName);
        summonerDTO = setDTO(responseName);

        ResponseEntity<String> byEncryptId = findEncryptId(summonerDTO.getId());
        List<LeagueEntryDTO> list = objectMapper.readValue(byEncryptId.getBody(),
                new TypeReference<List<LeagueEntryDTO>>() {});

//        Date date = new Date(summonerDTO.getRevisionDate());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        summonerDTO.setRevisionDate(();

        maps.put("summonerDTO", summonerDTO);
        maps.put("LeagueEntryDTO", list);


        return maps;
    }
}
