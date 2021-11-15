package com.hhgg.data.mapper;

import com.hhgg.data.dto.SummonerDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MybatisMapper {

    @Insert("INSERT INTO summoner(accountId, profileIconId, revisionDate, name, id, puuid, summonerLevel)" +
            "VALUES(" +
            "#{summonerDTO.accountId}, " +
            "#{summonerDTO.profileIconId}, " +
            "#{summonerDTO.revisionDate}, " +
            "#{summonerDTO.name}," +
            "#{summonerDTO.id}, " +
            "#{summonerDTO.puuid}, " +
            "#{summonerDTO.summonerLevel}" +
            ")")
    int insert(@Param("summonerDTO") SummonerDTO summonerDTO);

    @Select("SELECT * FROM SUMMONER WHERE NAME = #{summonerName}")
    SummonerDTO findByName(@Param("summonerName") String summonerName);
}
