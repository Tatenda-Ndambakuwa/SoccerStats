
//*********************
// soccerSummary Class
//-------------------------

//*********************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class soccerSummary
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Prompt for the input and output file names

        Scanner console = new Scanner(System.in);

        // Construct the Scanner and PrintWriter objects for reading and writing

        File inputFile = new File("SoccerStats.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("soccerSummary.txt");

        // Read the input and write the output

        String teamName = "";
        String minTeam = "";
        String maxTeam = "";
        double maxScore;
        double minScore;
        double teamScore;
        teamScore = 0;
        maxScore= 0;
        minScore=100;
        double teamAverage =0.0;
        double totalAverage =0.0;
        int counter =0;

     
        // We read a line at a time since there may be spaces in the item names
        while (in.hasNext())
        {
            teamName = in.next();
            teamScore = in.nextDouble(); //System.out.println(teamScore);
            teamAverage = in.nextDouble();

            if (teamScore < minScore)
            {
                minScore= teamScore;
                minTeam= teamName;
                
            }

            if (teamScore > maxScore)
            {
                maxScore= teamScore;
                maxTeam= teamName;
            }

            totalAverage= totalAverage + teamAverage;
              counter ++;
              
            

        } //endwhile

        double leagueAverage = totalAverage / counter ;
        out.println("Minimum goals Scored: " + minTeam + " = " + minScore);
        out.println("Maximum goals Scored: " + maxTeam + " = " + maxScore);
        out.print("Average shorts per game: ");
        out.printf("%3.3f %n", leagueAverage);

        in.close();
        out.close();
    }
}
