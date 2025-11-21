import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(read());

    }

    public static ScoreBoard[] read() throws FileNotFoundException {
        int RTotal = 0;//initialize variables
        int OTotal = 0;
        int YTotal = 0;
        int GTotal = 0;
        int BTotal = 0;
        int ITotal = 0;
        int VTotal = 0;
        File f = new File("ScoreBoard.txt");//document
        Scanner s = new Scanner(f);//scan the document
        ScoreBoard[] lines = new ScoreBoard[1000];//initialize the array of 1000 games
        int indexOfLines=0;

        while (s.hasNext()) {
            ScoreBoard score= new ScoreBoard(s.next(), s.next());
            while (s.hasNextInt()) { //now track the integers and add them up
                int num = s.nextInt();
                score.recordPlay(num);

            }
            lines[indexOfLines]= score; //assign indexoflines to score and increment
            indexOfLines++;


        }

        return lines;

    }

}
