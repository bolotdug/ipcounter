package ru.bolotdug;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

  private static String parseFileName(String[] args) throws FileNotFoundException {
    if (args.length > 0 && args[0] != null) {
      return args[0];
    } else {
      throw new FileNotFoundException("Send file as an argument");
    }
  }

  public static void main(String[] args) throws IOException {
    String fileName = parseFileName(args);

    BitSetUniqueIpCounter counter = new BitSetUniqueIpCounter();
    long numberOfUniqueIp = counter.countUniqueIp(fileName);
    System.out.println("Found " + numberOfUniqueIp + " unique IP's");
  }
}
