package com.hhgg.repository;

import com.hhgg.dto.SummonerDTO;

import java.util.HashMap;
import java.util.Map;

public class MemorySummonerRepository implements SummonerRepository {

    private static Map<String, SummonerDTO> store = new HashMap<>() ;

    @Override
    public void save(SummonerDTO summonerDTO) {

        store.put(summonerDTO.getName(),summonerDTO);



    }

    @Override
    public SummonerDTO findByName(String name) {

        return store.get(name);
    }
}
