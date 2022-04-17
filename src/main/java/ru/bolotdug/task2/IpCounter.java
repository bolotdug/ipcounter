package ru.bolotdug.task2;

import ru.bolotdug.task2.reader.IpFileReader;
import ru.bolotdug.task2.register.IpRegistrer;

public class IpCounter {

  private static String parseFileName(String[] args) {
    if (args.length > 0 && args[0] != null) {
      return args[0];
    } else {
      throw new IllegalArgumentException("Send file as an argument");
    }
  }

  public static void main(String[] args) {
    String fileName = parseFileName(args);
    
    IpFileReader reader = new IpFileReader();
    reader.readFile(fileName);
    long numberOfUniqueIp = IpRegistrer.counter;
    System.out.println("Found " + numberOfUniqueIp + " unique IP's");
  }
}
