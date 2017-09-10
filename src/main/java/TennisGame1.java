import tennisgameone.Score;

public class TennisGame1 implements TennisGame {

  private int m_score1 = 0;
  private int m_score2 = 0;
  private String player1Name;
  private String player2Name;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public void wonPoint(String playerName) {
    if (playerName == "player1")
      m_score1 += 1;
    else
      m_score2 += 1;
  }

  public String getScore() {
    if (doesPlayersHaveSameScore()) return Score.findByPointForSamePoint(m_score1);

    if (m_score1 >= 4 || m_score2 >= 4) {
      int pointDifference = m_score1 - m_score2;

      if (pointDifference == 1) {
        return "Advantage player1";
      }

      if (pointDifference == -1) {
        return "Advantage player2";
      }

      if (pointDifference >= 2) {
        return "Win for player1";
      }

      return "Win for player2";
    } else {
      return Score.findByPoint(m_score1) + "-" + Score.findByPoint(m_score2);
    }
  }

  private boolean doesPlayersHaveSameScore() {
    return m_score1 == m_score2;
  }
}
