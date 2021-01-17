/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

/**
 *
 * @author evoro
 */
public class Teams {  //Воротникова Е.Ю.

    private String name;
    private int win_total;
    private int loss_total;
    private int tie_total;
    private int goals_scored;
    private int goals_allowed;//пропущенные голы
//    private int nrOfTeam;
//    private static int count_of_teams=0;

    public void print() {

        System.out.println("Team " + "\"" + getName() + "\"");
        System.out.println("Wins: " + getWin_total() + ", "
                + "Losses: " + getLoss_total() + ", "
                + "Ties: " + getTie_total());

        System.out.println("Points Scored: " + getGoals_scored() + ", "
                + "Points Allowed: " + getGoals_allowed());
        System.out.println("\n");
    }

    
    public Teams(String name) {
        this.name = name;
        this.goals_allowed = 0;
        this.goals_scored = 0;
        this.loss_total =0;
        this.tie_total = 0;
        this.win_total =0;

    }

    public String getName() {
        return name;
    }

    public int getWin_total() {
        return win_total;
    }

    public int getLoss_total() {
        return loss_total;
    }

    public int getTie_total() {
        return tie_total;
    }

    public int getGoals_scored() {
        return goals_scored;
    }

    public int getGoals_allowed() {
        return goals_allowed;
    }

   

    public void setWin_total(int win_total) {
        this.win_total = win_total;
    }

    public void setLoss_total(int loss_total) {
        this.loss_total = loss_total;
    }

    public void setTie_total(int tie_total) {
        this.tie_total = tie_total;
    }

    public void setGoals_scored(int goals_scored) {
        this.goals_scored = goals_scored;
    }

    public void setGoals_allowed(int goals_allowed) {
        this.goals_allowed = goals_allowed;
    }
}
