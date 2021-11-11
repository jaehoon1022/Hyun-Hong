package com.hhgg.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MiniSeriesDTO {

    private int losses;
    private String progress;
    private int target;
    private int wins;

    public MiniSeriesDTO() {
    }
}
