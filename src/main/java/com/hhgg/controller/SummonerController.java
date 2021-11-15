package com.hhgg.controller;

import com.hhgg.data.dto.SummonerDTO;
import com.hhgg.data.mapper.MybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis")
public class SummonerController {

    private MybatisMapper mapper;

    @Autowired
    public SummonerController(MybatisMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("")
    public int post(@RequestBody SummonerDTO summonerDTO) {
        return mapper.insert(summonerDTO);
    }
}
