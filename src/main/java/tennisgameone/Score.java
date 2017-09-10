package tennisgameone;

import java.util.Arrays;

public enum Score {
  Love(0),
  Fifteen(1),
  Thirty(2),
  Forty(3),
  Deuce(4),
  All(5);

  public final int point;

  Score(int point) {
    this.point = point;
  }

  public static Score findByPoint(int pointToFind) {
    return Arrays.stream(values())
            .filter(score -> score.point == pointToFind)
            .findAny()
            .orElse(Deuce);
  }

  public static String findByPointForSamePoint(int pointToFind) {
    return Arrays.stream(values())
            .filter(score -> score.point <= 2)
            .filter(score -> score.point == pointToFind)
            .findAny()
            .map(score -> score.toString() + "-" + All.toString())
            .orElse(Deuce.toString());
  }
}
