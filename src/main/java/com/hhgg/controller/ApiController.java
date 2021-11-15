package com.hhgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hhgg.data.dao.SummonerDao;
import com.hhgg.data.dto.SummonerDTO;
import com.hhgg.data.mapper.MybatisMapper;
import com.hhgg.service.UserService;
import com.hhgg.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/main")
public class ApiController {

    private UserService userService;
    private MybatisMapper mapper;

    @Autowired
    public ApiController(UserService userService, MybatisMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/search")
    public SummonerDTO searchName(@RequestParam String summonerName) throws JsonProcessingException {

        log.info("summonerName 조회중...={}", summonerName);

        if (mapper.findByName(summonerName) == null) {

            log.info("DB에 summoner DATA 생성중...");

            mapper.insert(userService.essentialData(summonerName));

            log.info("DB에 summoner 정보를 생성하였습니다...");

        }
        else{
            log.info("DB에서 기존의 summoner 정보를 불러왔습니다..");
        }

        return mapper.findByName(summonerName);
    }

}
