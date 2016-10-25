package com.hacktoberfest;
import java.io.*;
import java.net.*;

public class HamsterHTTPNamefinder {

  /**
   * Send Post Request to url with the urlParameters and get the reponse as a String
   * @param url url to send post request
   * @param urlParameters post arguments to send in post request
   * @return Responde from website or null if error occured
   */
  public static String response(String url, String urlParameters) throws Exception {
    final URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", "HALLO");
    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    
    con.setDoOutput(true);
    
    try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
      wr.writeBytes(urlParameters);
      wr.flush();
    }

    final int responseCode = con.getResponseCode();
    if (responseCode != 200) {
      return null;
    }
  
    final StringBuffer response = new StringBuffer();  
    try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
      String inputLine;
      while((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
    }
    return response.toString();
  }
  
  /**
   * Parse Website to get hamstername
   * @returns name of an hamster or null if error occured
   */
  private static String name() throws Exception {
    final String response = response("http://names.pub/hamster-names", "male=true&requestType=newHamsterName");
    
    if (response == null) return null;
    final String search = "<p>Your Hamster Name is...</p>";
    final int index = response.indexOf(search) + search.length();
    if (index == -1) {
      System.out.println("Can't find name");
      return null;
    }
    final int start = response.indexOf('>', index) + 1;
    final int end = response.indexOf('<', start);
    final String name = response.substring(start, end);
    return name;
  }

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("Usage: Namefinder count");
      return;
    }
    int count = Integer.parseInt(args[0]);
    for (int i = 0; i < count; i++) {
      final String name = name();
      if (name == null) return;
      System.out.println(name);
    }
  }
}

