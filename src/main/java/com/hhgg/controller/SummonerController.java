//package com.hhgg.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.hhgg.data.dto.SummonerDTO;
//import com.hhgg.data.mapper.MybatisMapper;
//import com.hhgg.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/mybatis")
//@Slf4j
//public class SummonerController {
//
//    private MybatisMapper mapper;
//    private UserService userService;
//
//
//    @Autowired
//    public SummonerController(MybatisMapper mapper, UserService userService) {
//        this.mapper = mapper;
//        this.userService = userService;
//    }
//
//    @GetMapping("/get")
//    public SummonerDTO get(@RequestParam String summonerName) throws JsonProcessingException {
//
//        log.info("findByName={}", mapper.findByName(summonerName));
//
//        if(mapper.findByName(summonerName) == null) {
//            SummonerDTO summonerDTO = userService.essentialData(summonerName);
//            mapper.insert(summonerDTO);
//        }
//        return mapper.findByName(summonerName);
//
//    }
//
//    @PostMapping("")
//    public int post(@RequestBody SummonerDTO summonerDTO) {
//        return mapper.insert(summonerDTO);
//    }
//}
