public class ScoreBoard {
    private  String word;
    private String word2;
    private int scoreTeam1 =0;
    private int scoreTeam2=0;
    private boolean isActive=true;

    public ScoreBoard(String team1, String team2){
        word=team1;
        word2=team2;

    }

    public void recordPlay(int num){

        if(num==0){
            isActive=!isActive;
        }
        if(isActive) {
            scoreTeam1+=num;
        }
        else {
            scoreTeam2+=num;
        }

    }
    public String getScore(){
        String activeTeam=null;
        if(isActive){
            activeTeam=word;
        }
        else {
            activeTeam=word2;
        }
        return (scoreTeam1+"-" +scoreTeam2 + "-" +activeTeam);

    }
    public String getWinner()
    {

        if(scoreTeam1>scoreTeam2)
        {
            return word;
        }

        if(scoreTeam2>scoreTeam1)
        {
            return word2;
        }

        return null;
    }


}
