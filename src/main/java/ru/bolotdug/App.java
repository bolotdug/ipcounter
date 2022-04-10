package ru.bolotdug;

import java.io.IOException;


public class App {

  private static String parseFileName(String[] args) {

    String fileName = null;
    if (args.length == 2 && "-file".equals(args[0])) {
      fileName = args[1];
    }
    return fileName;
  }

  public static void main(String[] args) {
    String fileName = parseFileName(args);
    if (fileName == null) {
      System.out.println("Wrong arguments. Use '-file file_name' to specify file for processing");
      return;
    }

    BitSetUniqueIpCounter counter = new BitSetUniqueIpCounter();
    long numberOfUniqueIp = counter.countUniqueIp(fileName);
    if (numberOfUniqueIp != -1) {
      System.out.println("Found " + numberOfUniqueIp + " unique IP's");
    } else {
      System.out.println("Some errors here. Check log for details.");
    }
  }
}
