package ru.bolotdug.task2.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.bolotdug.task2.converter.IpConverter;
import ru.bolotdug.task2.register.IpRegistrer;

public class IpFileReader {

  private static final Logger logger = Logger.getLogger(String.valueOf(IpFileReader.class));
  private static final long NUMBER_OF_IP_ADDRESSES = 256L * 256 * 256 * 256;

  public void readFile(String fileName) {
    try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
      long readLines = 0;

      String line;
      while ((line = in.readLine()) != null && IpRegistrer.counter <= NUMBER_OF_IP_ADDRESSES) {
        IpRegistrer.registerIpAddress(IpConverter.getLongValueFromIPString(line));
        readLines++;
      }
      logger.log(Level.INFO, "Total lines processed: " + readLines);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File " + fileName + " not found");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
