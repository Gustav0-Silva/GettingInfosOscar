package org.example;
import org.example.mappers.ActorMapper;
import org.example.mappers.ActressMapper;
import org.example.model.WinnersData;
import org.example.service.WinnersService;
import org.example.util.FileUtil;
import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        var fileUtilMale = new FileUtil<WinnersData>("oscar_age_male.csv");
        var fileUtilFemale = new FileUtil<WinnersData>("oscar_age_female.csv");

        var actorData = fileUtilMale.readFile(new ActorMapper());
        var actressData = fileUtilFemale.readFile(new ActressMapper());

        var winnersService = new WinnersService(actorData,actressData);

        winnersService.prinOldestActor();
        winnersService.printOldestActress();
        winnersService.printOldestWinner();
        winnersService.printYoungestWinner();
        winnersService.mostWinnings();
        winnersService.actorMostWinnings();
    }
}
