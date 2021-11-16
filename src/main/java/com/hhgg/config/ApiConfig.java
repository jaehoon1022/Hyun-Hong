package com.hhgg.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhgg.data.dto.EssentialDTO;
import com.hhgg.data.dto.LeagueEntryDTO;
import com.hhgg.data.dto.SummonerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
public class ApiConfig {

    private static final String API_KEY = "RGAPI-fbbd0d1e-dbac-4405-976d-2da608ac552a";
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private SummonerDTO summonerDTO = new SummonerDTO();
    private LeagueEntryDTO leagueEntryDTO = new LeagueEntryDTO();
    private EssentialDTO essentialDTO = new EssentialDTO();

    public ResponseEntity<String> findSummonerName(String name){

        URI uri = UriComponentsBuilder.fromUriString("https://kr.api.riotgames.com")
                .path("/lol/summoner/v4/summoners/by-name/" + name)
                .queryParam("api_key", API_KEY)
                .encode()
                .build()
                .toUri();

        // 외부(RIOT) API를 호출하기위해 Spring의 RestTemplate 채택
        return restTemplate.getForEntity(uri, String.class);
    }

    public SummonerDTO setDTO(ResponseEntity<String> responseEntity) throws JsonProcessingException {

        // jackson 라이브러리를 이용하여 json을 java 객체로 바꿔 DTO 객체에 담는 과정
        SummonerDTO summonerDTO = objectMapper.readValue(responseEntity.getBody(), SummonerDTO.class);

        return summonerDTO;
    }


    public ResponseEntity<String> findEncryptId(String summonerId) {

        URI uri = UriComponentsBuilder.fromUriString("https://kr.api.riotgames.com")
                .path("/lol/league/v4/entries/by-summoner/" + summonerId)
                .queryParam("api_key", API_KEY)
                .encode()
                .build()
                .toUri();

        return restTemplate.getForEntity(uri, String.class);
    }

    public EssentialDTO essentialData(String summonerName) throws JsonProcessingException {

        ResponseEntity<String> responseName = findSummonerName(summonerName);
        summonerDTO = setDTO(responseName);

        String summonerId = summonerDTO.getId();

        log.info("---- SUMMONER ID ---- = {}", summonerId);

        ResponseEntity<String> byEncryptId = findEncryptId(summonerId);

        List<LeagueEntryDTO> list = objectMapper.readValue(byEncryptId.getBody(),
                new TypeReference<List<LeagueEntryDTO>>() {});

        Date date = new Date(summonerDTO.getRevisionDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        essentialDTO.setId(summonerDTO.getId());
        essentialDTO.setProfileIconId(summonerDTO.getProfileIconId());
        essentialDTO.setName(summonerDTO.getName());
        essentialDTO.setSummonerLevel(summonerDTO.getSummonerLevel());
        essentialDTO.setRevisionDate(sdf.format(date));
        essentialDTO.setQueueType(list.get(0).getQueueType());
        essentialDTO.setTier(list.get(0).getTier());
        essentialDTO.setRank(list.get(0).getRank());
        essentialDTO.setWins(list.get(0).getWins());
        essentialDTO.setLosses(list.get(0).getLosses());
        essentialDTO.setLeaguePoints(list.get(0).getLeaguePoints());

        return essentialDTO;
    }
}
