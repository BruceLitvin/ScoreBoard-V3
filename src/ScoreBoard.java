public class ScoreBoard {
    private String word;    //initialize strings
    private String word2;
    private int scoreTeam1 = 0; //now the ints
    private int scoreTeam2 = 0;
    private boolean isActive = true; //and booleans

    public ScoreBoard(String team1, String team2) { //constructor to make lives easier
        word = team1;
        word2 = team2;

    }

    public void recordPlay(int num) { //tracks points in games played

        if (num == 0) {
            isActive = !isActive; //if value is zero change active team
        }
        else if (isActive) {
            scoreTeam1 += num;
        }
        else {
            scoreTeam2 += num;
        }

    }

    public String getScore() { //add score to team that is active
        String activeTeam = null;
        if (isActive) {
            activeTeam = word;
        }
        else {
            activeTeam = word2;
        }
        return (scoreTeam1 + "-" + scoreTeam2 + "-" + activeTeam);

    }

    public String getWinner() //determine a winner by comparing scores
    {

        if (scoreTeam1 > scoreTeam2) {
            return word;
        }

        if (scoreTeam2 > scoreTeam1) {
            return word2;
        }

        return null;
    }


}
