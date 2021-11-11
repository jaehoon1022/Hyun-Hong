package com.hhgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhgg.config.ApiConfig;
import com.hhgg.config.AppConfig;
import com.hhgg.dto.EssentialDTO;
import com.hhgg.dto.LeagueEntryDTO;
import com.hhgg.dto.SummonerDTO;
import com.hhgg.service.UserService;
import com.hhgg.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("/main")
public class ApiController {


    @GetMapping("/search")
    public Map<String, Object> searchName(@RequestParam String summonerName) throws JsonProcessingException {
//
//        ApiConfig apiConfig = new ApiConfig();
//
//        return apiConfig.essentialData(summonerName);
        UserService userService = new UserServiceImpl();

        log.info("---요청이 왔습니다.---={}", userService.essentialData(summonerName));
        
        return userService.essentialData(summonerName);
    }

}
