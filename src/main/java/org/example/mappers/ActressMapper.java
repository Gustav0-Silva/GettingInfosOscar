package org.example.mappers;

import org.example.model.WinnersData;

import java.util.function.Function;

public class ActressMapper implements Function<String, WinnersData> {

    @Override
    public WinnersData apply(String s) {
        var dadosLinha = s.split("; ");
        var id = Integer.parseInt(dadosLinha[0]);
        var awardYear = Integer.parseInt(dadosLinha[1]);
        var age = Integer.parseInt(dadosLinha[2]);
        var name = dadosLinha[3];
        var movie = dadosLinha[4];
        char sex = 'F';
        var award = 1;

        return new WinnersData(id,awardYear,age,name,movie,sex,award);
    }
}