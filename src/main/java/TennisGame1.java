import tennisgameone.Score;

public class TennisGame1 implements TennisGame {
  private int pointsOfPlayerOne = 0;
  private int pointsOfPlayerTwo = 0;

  public void wonPoint(String playerName) {
    if (playerOneMarkedThePoint(playerName))
      pointsOfPlayerOne += 1;
    else
      pointsOfPlayerTwo += 1;
  }

  public String getScore() {
    if (playersHaveSameScore()) return Score.findByPointForSamePoint(pointsOfPlayerOne);

    if (thereIsAdvantageOrAWin())
      return getMessageAdvantageOrWin(pointsOfPlayerOne - pointsOfPlayerTwo)
              + getAdvantagedPlayer(pointsOfPlayerOne - pointsOfPlayerTwo);

    return Score.findByPoint(pointsOfPlayerOne) + "-" + Score.findByPoint(pointsOfPlayerTwo);
  }

  private boolean playerOneMarkedThePoint(String playerName) {
    return playerName.equals("player1");
  }

  private String getMessageAdvantageOrWin(int pointDifference) {
    return Math.abs(pointDifference) == 1 ? "Advantage " : "Win for ";
  }

  private String getAdvantagedPlayer(int pointDifference) {
    return pointDifference > 0 ? "player1" : "player2";
  }

  private boolean thereIsAdvantageOrAWin() {
    return pointsOfPlayerOne >= 4 || pointsOfPlayerTwo >= 4;
  }

  private boolean playersHaveSameScore() {
    return pointsOfPlayerOne == pointsOfPlayerTwo;
  }
}
