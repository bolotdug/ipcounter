package ru.bolotdug.task2.converter;

public class IpConverter {

  private static final String dividerIPAddressByDot = "\\.";

  public static long getLongValueFromIPString(String ipString) {

    long longValueFromIPString = 0;
    String[] partsOfIPAddress = ipString.split(dividerIPAddressByDot);
    for(int i = 0; i < partsOfIPAddress.length; i++){
      longValueFromIPString += Integer.parseInt(partsOfIPAddress[i]) * Math.pow(256, 3 - i);
    }
    return longValueFromIPString;
  }
}
