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

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public SummonerDTO searchName(@RequestParam String summonerName) throws JsonProcessingException {


        log.info("---요청이 왔습니다.---={}", userService.essentialData(summonerName));




        return userService.essentialData(summonerName);
    }

}
