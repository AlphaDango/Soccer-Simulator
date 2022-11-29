package de.szut.soccer;

import java.util.Random;

public class SoccerManagerUI {
    public static void main(String[] args) {
        Coach coach = new Coach("Kohfeld", 38, 9);
        Goalkeeper goalkeeper = new Goalkeeper("Pavlenka", 28, 6, 2, 10, 6, 6);
        Team werder = new Team("Werder Bremen", coach, goalkeeper);
        werder.addPlayer(new Player("Gebre Selassie", 34, 7, 6, 8, 0));
        werder.addPlayer(new Player("Friedl", 22, 6, 6, 8, 0));
        werder.addPlayer(new Player("Veljkoviv", 24, 6, 5, 8, 0));
        werder.addPlayer(new Player("Augustinsson", 26, 7, 5, 7, 0));
        werder.addPlayer(new Player("Mbom", 20, 6, 6, 8, 0));
        werder.addPlayer(new Player("Eggestein", 24, 8, 6, 8, 0));
        werder.addPlayer(new Player("Füllkrug", 27, 8, 9, 8, 0));
        werder.addPlayer(new Player("Osako", 30, 7, 8, 8, 0));
        werder.addPlayer(new Player("Rashica", 24, 8, 8, 8, 0));
        werder.addPlayer(new Player("Bittencourt", 27, 7, 7, 8, 0));


        Coach coach2 = new Coach("Terzic", 38, 5);
        Goalkeeper goalkeeper2 = new Goalkeeper("Bürki", 30, 7, 2, 10, 7,6);
        Team dortmund = new Team("Borussia Dortmund", coach2, goalkeeper2);
        dortmund.addPlayer(new Player("Meunier", 29, 7, 5, 8, 0));
        dortmund.addPlayer(new Player("Akanji", 25, 8, 6, 8, 0));
        dortmund.addPlayer(new Player("Hummels", 31, 9, 5, 8, 0));
        dortmund.addPlayer(new Player("Guerreiro", 26, 8, 9, 8, 0));
        dortmund.addPlayer(new Player("Witsel", 31, 9, 6, 8, 0));
        dortmund.addPlayer(new Player("Brandt", 24, 9, 8, 8, 0));
        dortmund.addPlayer(new Player("Sancho", 20, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Bellingham", 17, 7, 7, 7, 0));
        dortmund.addPlayer(new Player("Reus", 31, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Haaland", 20, 9, 9, 8, 0));

        Game game = new Game(dortmund,werder);

        Gameplay gameplay = new Gameplay(game);
        gameplay.play();

    }
}
