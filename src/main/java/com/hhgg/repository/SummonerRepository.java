package com.hhgg.repository;

import com.hhgg.dto.SummonerDTO;

public interface SummonerRepository {

    void save(SummonerDTO summonerDTO);

    SummonerDTO findByName(String name);
}
