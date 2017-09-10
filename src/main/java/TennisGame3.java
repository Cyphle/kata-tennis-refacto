
public class TennisGame3 implements TennisGame {
    
    private int pointsPlayerTwo;
    private int pointsPlayerOne;
    private String playerOne;
    private String playerTwo;

    public TennisGame3(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        String s;
        if (pointsPlayerOne < 4 && pointsPlayerTwo < 4 && !(pointsPlayerOne + pointsPlayerTwo == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[pointsPlayerOne];
            return (pointsPlayerOne == pointsPlayerTwo) ? s + "-All" : s + "-" + p[pointsPlayerTwo];
        } else {
            if (pointsPlayerOne == pointsPlayerTwo)
                return "Deuce";
            s = pointsPlayerOne > pointsPlayerTwo ? playerOne : playerTwo;
            return ((pointsPlayerOne - pointsPlayerTwo)*(pointsPlayerOne - pointsPlayerTwo) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.pointsPlayerOne += 1;
        else
            this.pointsPlayerTwo += 1;
        
    }

}
