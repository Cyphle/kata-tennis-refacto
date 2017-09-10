package tennisgametwo;

import java.util.Arrays;

public enum Score {
  Love(0),
  Fifteen(1),
  Thirty(2),
  Forty(3);

  public final int point;

  Score(int point) {
    this.point = point;
  }

  public static String findScoreByPoint(int pointToFind) {
    return Arrays.stream(values())
            .filter(score -> score.point == pointToFind)
            .findAny()
            .orElse(Love)
            .toString();
  }
}
