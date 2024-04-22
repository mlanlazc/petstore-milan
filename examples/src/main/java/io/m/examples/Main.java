package io.github.mlanlazc.examples;

import io.github.mlanlazc.Milanpetstoresdk;
import io.github.mlanlazc.exceptions.ApiException;

public class Main {

  public static void main(String[] args) {
    Milanpetstoresdk client = new Milanpetstoresdk();
    try {
      Object response = client.petsService.listPets(6);
      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }
  }
}
