import tennisgametwo.Score;

public class TennisGame2 implements TennisGame {
  private int P1point = 0;
  private int P2point = 0;

  public String getScore() {
    if (playersHaveSameScore()) {
      if (scoreIsHigherThanThreePoints())
        return "Deuce";
      else
        return Score.findScoreByPoint(P1point) + "-All";
    }

    if (gameIsNotFinished())
      return Score.findScoreByPoint(P1point) + "-" + Score.findScoreByPoint(P2point);

    String score = "";
    if (P1point > P2point) {
      if (P2point >= 3) score = "Advantage player1";
      if ((P1point - P2point) >= 2) score = "Win for player1";
    }

    if (P2point > P1point) {
      if (P1point >= 3) score = "Advantage player2";
      if ((P2point - P1point) >= 2) score = "Win for player2";
    }
    return score;
  }

  private boolean gameIsNotFinished() {
    return P1point > P2point && P1point < 4 || P2point > P1point && P2point < 4;
  }

  private boolean scoreIsHigherThanThreePoints() {
    return P1point >= 3;
  }

  private boolean playersHaveSameScore() {
    return P1point == P2point;
  }

  private void P1Score() {
    P1point++;
  }

  private void P2Score() {
    P2point++;
  }

  public void wonPoint(String player) {
    if (player.equals("player1"))
      P1Score();
    else
      P2Score();
  }
}