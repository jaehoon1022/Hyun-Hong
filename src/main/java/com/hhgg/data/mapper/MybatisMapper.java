package com.hhgg.data.mapper;

import com.hhgg.data.dto.SummonerDTO;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM SUMMONER WHERE id = #{summonerId}")
    SummonerDTO findByName(@Param("summonerId") String summonerId);

    @Update("UPDATE SUMMONER SET name = #{summonerDTO.name}, summonerLevel= #{summonerDTO.summonerLevel}," +
            "profileIconId = #{summonerDTO.profileIconId}, revisionDate = #{summonerDTO.revisionDate} " +
            "WHERE ID = #{summonerDTO.id}")
    SummonerDTO updateByName(@Param("summonerDTO") SummonerDTO summonerDTO);

}
