import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
 //test cases
          String info;
        ScoreBoard game=new ScoreBoard("Red", "Blue");
        info=game.getScore();
        System.out.println(info);
        game.recordPlay(1);
        info=game.getScore();
        System.out.println(info);
        game.recordPlay(0);
        info=game.getScore();
        System.out.println(info);
        info=game.getScore();
        System.out.println(info);
        game.recordPlay(3);
        info=game.getScore();
        System.out.println(info);
        game.recordPlay(1);
        game.recordPlay(0);
        info=game.getScore();
        System.out.println(info);
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        info=game.getScore();
        System.out.println(info);

        ScoreBoard match = new ScoreBoard("Lions", "Tigers");
        info=match.getScore();
        System.out.println(info);

        info=game.getScore();
        System.out.println(info);

        Main main = new Main();
        ScoreBoard[] scores = main.read();
        main.winCount(scores);


    }

    public ScoreBoard[] read() throws FileNotFoundException {

        File f = new File("ScoreBoard.txt");//document
        Scanner s = new Scanner(f);//scan the document
        ScoreBoard[] scores = new ScoreBoard[1000];//initialize the array of 1000 games
        int indexOfLines = 0;

        while (s.hasNext()) {
            ScoreBoard score = new ScoreBoard(s.next(), s.next());
            while (s.hasNextInt()) { //now track the integers and add them up
                int num = s.nextInt();
                score.recordPlay(num);

            }
            scores[indexOfLines] = score; //assign indexoflines to score and increment
            indexOfLines++;


        }

        return scores;

    }

    public void winCount(ScoreBoard[] scores) {
        int RTotal = 0;//initialize variables
        int OTotal = 0;
        int YTotal = 0;
        int GTotal = 0;
        int BTotal = 0;
        int ITotal = 0;
        int VTotal = 0;
        int ties = 0;
        for (int i = 0; i < scores.length; i++) {
            ScoreBoard score = scores[i]; //capture values from array
            String winner = score.getWinner(); //call a method to get winner
            if (winner == null) {  //the trash bin for ties
                ties++;
            } else if (winner.equals("Red")) {  //count red wins
                RTotal++;
            } else if (winner.equals("Orange")) { //repeat for all colors
                OTotal++;
            } else if (winner.equals("Yellow")) {
                YTotal++;
            } else if (winner.equals("Green")) {
                GTotal++;
            } else if (winner.equals("Blue")) {
                BTotal++;
            } else if (winner.equals("Indigo")) {
                ITotal++;
            } else if (winner.equals("Violet")) {
                VTotal++;
            }
        }
        System.out.println("Red:" + RTotal); //print total for all colors in order of rainbow
        System.out.println("Orange:" + OTotal);
        System.out.println("Yellow:" + YTotal);
        System.out.println("Green:" + GTotal);
        System.out.println("Blue:" + BTotal);
        System.out.println("Indigo:" + ITotal);
        System.out.println("Violet:" + VTotal);
        System.out.println("Ties:" + ties); //printed bc it may be good for later

    }
}
