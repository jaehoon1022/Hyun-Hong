package com.hhgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hhgg.data.dao.SummonerDao;
import com.hhgg.data.dto.LeagueEntryDTO;
import com.hhgg.data.dto.SummonerDTO;
import com.hhgg.data.mapper.MybatisMapper;
import com.hhgg.service.UserService;
import com.hhgg.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        SummonerDTO summonerDTO = userService.setDTO(userService.findSummonerName(summonerName));

        if (mapper.findByName(summonerDTO.getId()) == null) {

            log.info("DB에 summoner DATA 생성중...");

            mapper.insert(summonerDTO);

            log.info("DB에 summoner 정보를 생성하였습니다...");

            return mapper.findByName(summonerName);

        }
        else if(mapper.findByName(summonerDTO.getId()).getRevisionDate() != summonerDTO.getRevisionDate()){

            log.info("DB에 summoner 정보를 UPDATE 중입니다...");

            mapper.updateByName(summonerDTO);

            return mapper.findByName(summonerName);
        }
        else
            log.info("DB 에서 기존의 summoner 정보를 불러왔습니다..");
            return mapper.findByName(summonerDTO.getId());
    }

    @GetMapping("/search2")
    public ResponseEntity<String> test01(@RequestParam String summonerId){



        return userService.findByEncryptId(summonerId);

    }

}
