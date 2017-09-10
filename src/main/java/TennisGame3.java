
public class TennisGame3 implements TennisGame {
    private final String[] scorePointsCorrespondence = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int pointsPlayerTwo;
    private int pointsPlayerOne;
    private String playerOne;
    private String playerTwo;

    public TennisGame3(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        String score;
        if (pointsPlayerOne < 4 && pointsPlayerTwo < 4 && !(pointsPlayerOne + pointsPlayerTwo == 6)) {
            return scorePointsCorrespondence[pointsPlayerOne] + ((pointsPlayerOne == pointsPlayerTwo) ? "-All" : "-" + scorePointsCorrespondence[pointsPlayerTwo]);
        } else {
            if (pointsPlayerOne == pointsPlayerTwo)
                return "Deuce";
            score = pointsPlayerOne > pointsPlayerTwo ? playerOne : playerTwo;
            return ((pointsPlayerOne - pointsPlayerTwo)*(pointsPlayerOne - pointsPlayerTwo) == 1) ? "Advantage " + score : "Win for " + score;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.pointsPlayerOne += 1;
        else
            this.pointsPlayerTwo += 1;
        
    }

}
