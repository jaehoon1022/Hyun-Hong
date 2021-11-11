/*

package com.hhgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhgg.dto.SummonerDTO;
import com.hhgg.repository.SummonerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/main")
public class MainController {

    //    @Value("${API-KEY}")
    private static final String API_KEY = "RGAPI-fbbd0d1e-dbac-4405-976d-2da608ac552a";

    @GetMapping("/search/{summonerName}")
        public Mono<String> search(@PathVariable String summonerName ) {

        ObjectMapper objectMapper = new ObjectMapper();

//        WebClient webClient = WebClient.create("https://kr.api.riotgames.com");
        WebClient webClient = WebClient.builder().baseUrl("https://kr.api.riotgames.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

        Mono<String> mono = webClient.get()
                .uri("/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key={API_KEY}", API_KEY)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);


//        SummonerDTO summonerDTO = objectMapper.readValue(mono, SummonerDTO.class);

            return mono;
    }


}
*/