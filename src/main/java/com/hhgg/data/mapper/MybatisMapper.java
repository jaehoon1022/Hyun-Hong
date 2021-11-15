package com.hhgg.data.mapper;

import com.hhgg.data.dto.SummonerDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MybatisMapper {

    @Insert("INSERT INTO summoner(accountId, profileId, revisionDate, name, id, puuid, summonerLevel)" +
            "VALUES(" +
            "#{summonerDTO.accountId}, " +
            "#{summonerDTO.profileId}, " +
            "#{summonerDTO.revisionDate}, " +
            "#{summonerDTO.name}," +
            "#{summonerDTO.name}, " +
            "#{summonerDTO.id}, " +
            "#{summonerDTO.puuid}, " +
            "#{summonerDTO.summonerLevel}" +
            ")")
    int insert(@Param("summoner") SummonerDTO summonerDTO);
}
