package com.hhgg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class EssentialDTO {

    private String id;
    private String name;
    private String revisionDate;
    private int profileIconId;
    private long summonerLevel;
    private String queueType;
    private int leaguePoints;
    private String tier;
    private String rank;
    private int wins;
    private int losses;

    public EssentialDTO() {


    }
}



