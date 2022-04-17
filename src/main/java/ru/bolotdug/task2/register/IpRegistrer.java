package ru.bolotdug.task2.register;

public class IpRegistrer {

  public static long counter;
  private static int[] arrayOfRegisteredIps = new int[1 << 27];

  public static void registerIpAddress(long longValue) {
    int indexOfArray = (int) (longValue >> 5);
    int bit = 1 << (longValue & 31);
    if ((arrayOfRegisteredIps[indexOfArray] & bit) == 0) {
      counter++;
      arrayOfRegisteredIps[indexOfArray] |= bit;
    }
  }
}
