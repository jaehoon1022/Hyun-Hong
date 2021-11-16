package com.hhgg.data.dao;

import com.hhgg.data.dto.SummonerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SummonerDao {

    void saveName(SummonerDTO summonerDTO);

    SummonerDTO findByName(String summonerId);

}
