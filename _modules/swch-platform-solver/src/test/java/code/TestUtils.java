package code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtils {
  public static Long getRandom() {
    return Double.valueOf(Math.abs(Math.random() * 10000) + 500).longValue();
  }

  public static void sleep() {
    try {
      Long random = getRandom();
      log.info("sleeping for: {} milis", random);
      Thread.sleep(random);
    } catch (InterruptedException ignored) {
    }
  }
}