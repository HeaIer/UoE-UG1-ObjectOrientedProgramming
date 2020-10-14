package Week2.Q11;

public class Gambler
{
    public static void main(String[] args)
    {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int num_trials = Integer.parseInt(args[2]);
        double prob_of_win = Double.parseDouble(args[3]);

        int bets = 0;
        int wins = 0;

        for (int t = 0; t < num_trials; t++)
        {
            int cash = stake;
            while (cash > 0 && cash < goal)
            {
                bets++;
                if (Math.random() < 0.5 ) cash++;
                else                      cash--;
            }
            if (cash == goal) wins++;
        }

        System.out.println(100 * prob_of_win + "% wins");
        System.out.println("Avg # bets: " + bets/num_trials);

    }
}