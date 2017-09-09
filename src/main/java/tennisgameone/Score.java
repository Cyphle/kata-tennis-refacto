package tennisgameone;

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

  public static Score findByPoint(int pointToFind) {
    return Arrays.asList(values())
            .stream()
            .filter(score -> score.point == pointToFind)
            .findAny()
            .orElse(Love);
  }
}
