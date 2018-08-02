package gfg._1Stickler;

public class Solution {

    int moneyInTheHouse[];

    public Solution(int[] money){
        moneyInTheHouse = money ;
    }

    public void showMeMoney(){
        for(int i : moneyInTheHouse)
        System.out.println(i);
    }

    public void stealPlan() {
        int sum = 0;

//        stealPlan(moneyInTheHouse,i);
    }

    public static void main(String args[]){
        int[] m = {5, 5, 10, 100, 10, 5} ;

        Solution soln = new Solution(m);
        soln.showMeMoney();
        soln.stealPlan();
    }
}
