/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author evoro
 */
public class Games {  //¬оротникова ≈.ё.

    private Teams team1;
    private Teams team2;
    private int team1_score;
    private int team2_score;
    private int temperature;
    //static private int amountOfGames = 0;
    private int ID;
    // Teams team;
    static private ArrayList<Games> games;

    public Games(int ID, int temperature, Teams team1, Teams team2,
            int team1_score, int team2_score) {
        this.ID = ID;
        this.temperature = temperature;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        //games.add(ID,ID);
    }

    public void displayGame() {

        System.out.println("Game #" + ID);
        System.out.println("Temperature: " + temperature);
        System.out.println("Away Team: \"" + team1.getName() + "\" Scores: " + team1_score);
        System.out.println("Home Team: \"" + team2.getName() + "\" Scores: " + team2_score);
        System.out.println("");

    }

    public void getScoresOfBothTeams(Teams team1, Teams team2, int temp) { //дл€ одной игры
        Random rd = new Random();
        if (temp == 0||temp<=3) {//при низкой температуре количество голов меньше 
            setTeam1_score(rd.nextInt(3)); //очки первой комнады

            setTeam2_score(rd.nextInt(3)); //очки второй команды
        } else if (temp <= 6) {
            setTeam1_score(rd.nextInt(temp)); //очки первой комнады

            setTeam2_score(rd.nextInt(temp)); //очки второй команды
        } else if (temp < 15) {
            setTeam1_score(rd.nextInt(temp / 2 + 3)); //очки первой комнады

            setTeam2_score(rd.nextInt(temp / 2 + 3)); //очки второй команды
        } 
        else {// ¬ жаркие дни защитники пассивны. ѕоэтому в такие дни
            //растет веро€тность увеличени€ количества голов за игру. 

            setTeam1_score(rd.nextInt(temp / 4 + 7)); //очки первой комнады

            setTeam2_score(rd.nextInt(temp / 4 + 7)); //очки второй команды
        }

        if (team1_score > team2_score) {
            team1.setWin_total(team1.getWin_total() + 1);
            team2.setLoss_total(team2.getLoss_total() + 1);
        } else if (team1_score == team2_score) {
            team1.setTie_total(team1.getTie_total() + 1);
            team2.setTie_total(team2.getTie_total() + 1);
        } else {
            team2.setWin_total(team2.getWin_total() + 1);
            team1.setLoss_total(team1.getLoss_total() + 1);
        }

        team1.setGoals_scored(team1.getGoals_scored() + team1_score);
        team1.setGoals_allowed(team1.getGoals_allowed() + team2_score);

        team2.setGoals_scored(team2.getGoals_scored() + team2_score);
        team2.setGoals_allowed(team2.getGoals_allowed() + team1_score);
    }

    public void setTeam1_score(int team1_score) {
        this.team1_score = team1_score;
    }

    public void setTeam2_score(int team2_score) {
        this.team2_score = team2_score;
    }

    public static void setGames(ArrayList<Games> aGames) {
        games = aGames;
    }

}
