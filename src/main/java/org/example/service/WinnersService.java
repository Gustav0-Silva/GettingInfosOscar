package org.example.service;

import org.example.model.WinnersData;

import java.awt.event.WindowEvent;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinnersService {

    private List<WinnersData> winnersList;

    public WinnersService(List<WinnersData> winnersList) {
        this.winnersList= winnersList;
    }

    public void printOldestWinner(){
        var oldestWinner = winnersList.stream()
                .max(Comparator.comparingInt(WinnersData::getAge));

        oldestWinner.ifPresent(p -> System.out.printf("O vencedor mais " +
                "velho entre homens e mulheres é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void printYoungestWinner(){
        var youngestWinner = winnersList.stream()
                .min(Comparator.comparingInt(a->a.getAge()));

        youngestWinner.ifPresent(p-> System.out.printf("O vencedor mais" +
                " novo entre homens e mulheres é %s com %d anos \n",p.getName(),p.getAge()));
    }

    public void prinOldestActor(){
         var oldestActor = winnersList.stream()
                .collect(Collectors.filtering(i -> i.getSex() == 'M',Collectors.toList()))
                 .stream()
                 .max(Comparator.comparingInt(WinnersData::getAge));

        oldestActor.ifPresent(p -> System.out.printf("O vencedor mais " +
                "velho é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void printBetween(){
        winnersList.stream()
                .filter(a -> a.getAge() > 18 && a.getAge() <24)
                .collect(Collectors.groupingBy(WinnersData::getName))
                .forEach((key, value)->
                        System.out.printf("Nome: %-20s | Idade: %d \n", value.get(0).getName(), value.get(0).getAge()));
    }

    public void printOldestActress(){
        var oldestActor = winnersList.stream()
                .collect(Collectors.filtering(i -> i.getSex() == 'F',Collectors.toList()))
                .stream()
                .max(Comparator.comparingInt(WinnersData::getAge));

        oldestActor.ifPresent(p -> System.out.printf("A vencedora mais " +
                "velha é %s com %d anos\n", p.getName(), p.getAge()));
    }

    public void printYoungestActor(){
        var youngestActor = winnersList.stream()
                .collect(Collectors.filtering(i -> i.getSex() == 'M',Collectors.toList()))
                .stream()
                .min(Comparator.comparingInt(WinnersData::getAge));

        youngestActor.ifPresent(p -> System.out.printf("O vencedor mais " +
                "novo é %s com %d anos\n", p.getName(), p.getAge()));

    }

    public void printYoungestActress(){
        var youngestActress = winnersList.stream()
                .collect(Collectors.filtering(i -> i.getSex() == 'F',Collectors.toList()))
                .stream()
                .min(Comparator.comparingInt(WinnersData::getAge));

        youngestActress.ifPresent(p -> System.out.printf("A vencedora mais " +
                "nova é %s com %d anos\n", p.getName(), p.getAge()));

    }

    public void mostWinnings(){
        var personWithMostWinnings = winnersList.stream()
                .collect(Collectors.groupingBy(n->
                        n.getName(),
                        Collectors.summingInt(WinnersData::getAward)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        personWithMostWinnings.ifPresent(c-> System.out.printf("A pessoa com " +
                "mais estatuetas é %s com %d vitórias\n", c.getKey(),c.getValue()));
    }

    public void actorMostWinnings(){
        var actorWithMostWinnings = winnersList.stream()
                .collect(Collectors.filtering(i->i.getSex() == 'M',
                        Collectors.groupingBy(n->n.getName(),
                                Collectors.summingInt(WinnersData::getAward))))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        actorWithMostWinnings.ifPresent(c-> System.out.printf("O homem com mais " +
                "estatuetas é %s com %d vitórias\n",c.getKey(),c.getValue()));
    }

}
