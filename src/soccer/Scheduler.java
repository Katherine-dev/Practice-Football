/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author evoro
 */
public class Scheduler {

    public static void MakeSchedule() {//Воротникова Е.Ю.
        Scanner sc = new Scanner(System.in);
        Teams[] teams = new Teams[4];

        teams[0] = new Teams("Барселона");
        teams[1] = new Teams("Зенит");
        teams[2] = new Teams("Спартак");
        teams[3] = new Teams("Манчестер");

        //teams[0].print();
        boolean flag = true;
        int freeze = 0;
        double sum_temp = 0;
        double max_temp = 0;
        int count_of_plays = 0;
        int id_for_two_teams = 0;
        int temp = 0;
        
        ArrayList<Games> games = new ArrayList<>();
        while (flag) {

            do {
                System.out.println("\nEnter temperature as integer in °C smaller than 40:");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number!");
                    sc.next();
                }

                temp = sc.nextInt();
            } while (temp >= 40);
            System.out.println("");
            if (temp < 0) {
                System.out.println("Too cold to play.");
                freeze++;
                if (freeze == 3) {
                    System.out.println("Season is over\n\n");
                    if (count_of_plays > 0) {
                        System.out.print("*********РЕЗУЛЬТАТЫ*********");
                        System.out.println("\n");
                    }
                    flag = false;
                }

            } else {
                freeze = 0;
                if (temp > max_temp) {
                    max_temp = temp;
                }
                sum_temp = temp + sum_temp;
                count_of_plays++;

                Random rd = new Random();
                int team1 = rd.nextInt(4);
                int team2 = rd.nextInt(4);
                while (team2 == team1) {
                    team2 = rd.nextInt(4);
                }

                id_for_two_teams++; //id первой из двух игр
                Games game1 = new Games(id_for_two_teams, temp, teams[team1], teams[team2], 0, 0);
                game1.getScoresOfBothTeams(teams[team1], teams[team2], temp);
                games.add(game1);

                int team3 = rd.nextInt(4);
                int team4 = rd.nextInt(4);
                while (team3 == team1 || team3 == team2) {
                    team3 = rd.nextInt(4);
                }
                while (team4 == team1 || team4 == team2 || team4 == team3) {
                    team4 = rd.nextInt(4);
                }

                //game1.displayGame();
                id_for_two_teams++; //id второй из двух игр
                Games game2 = new Games(id_for_two_teams, temp, teams[team3], teams[team4], 0, 0);
                game2.getScoresOfBothTeams(teams[team3], teams[team4], temp);
                games.add(game2);
                //  game2.displayGame();

            }

        }

        for (int i = 0; i < 4; i++) {

            if (count_of_plays > 0) {
                teams[i].print();
            }
        }
        Iterator<Games> iterator = games.iterator(); //создаем итератор

        while (iterator.hasNext()) {
            //до тех пор, пока в списке есть элементы
            Games every_game = iterator.next();
            if (count_of_plays > 0) { //проверка на наличие хотя бы одной игры
                every_game.displayGame();

            }
        }
        if (count_of_plays > 0) {

            System.out.println("Hottest Temp: " + max_temp + "\n"
                    + "Average Temp: " + sum_temp / count_of_plays + "\n");
        }

        Games.setGames(games);

    }

}
