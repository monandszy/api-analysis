package code;

import javax.swing.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationRunner.class, args);
  }

  // I don't remember what this does
  public void run(String... args) throws Exception {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame();
      frame.setVisible(true);
    });
  }

}