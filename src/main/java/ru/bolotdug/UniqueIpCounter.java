package ru.bolotdug;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniqueIpCounter {

  long NUMBER_OF_IP_ADDRESSES = 256L * 256 * 256 * 256;
  private final Logger logger = Logger.getLogger("UniqueIpCounter");
  int[] seen = new int[1 << 27];
  private long counter = 0;

  private void registerIpAddress(long longValue) {
    int index = (int) (longValue >> 5);
    int bit = 1 << (longValue & 31);
    if ((seen[index] & bit) == 0) {
      counter++;
      seen[index] |= bit;
    }
  }

  public long countUniqueIp(String fileName) throws IOException {
    logger.log(Level.INFO, "Reading file: " + fileName);
    try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
      long readLines = 0;

      String line;
      while ((line = in.readLine()) != null && counter <= NUMBER_OF_IP_ADDRESSES) {
        registerIpAddress(toLongValue(line));
        readLines++;
      }
      logger.log(Level.INFO, "Total lines processed: " + readLines);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File " + fileName + " not found");
    } catch (IOException e) {
      throw new IOException("IOException occurred");
    }
    return counter;
  }

  private long toLongValue(String ipString) {

    long longValue = 0;
    String[] fields = ipString.split("\\.");
    for(int i = 0; i < fields.length; i++){
      longValue += Integer.parseInt(fields[i]) * Math.pow(256, 3 - i);
    }
    return longValue;
  }
}
