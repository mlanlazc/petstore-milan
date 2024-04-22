package io.github.mlanlazc;

import io.github.mlanlazc.Environment;
import io.github.mlanlazc.http.interceptors.DefaultHeadersInterceptor;
import io.github.mlanlazc.http.interceptors.RetryInterceptor;
import io.github.mlanlazc.services.*;
import java.util.Map;
import okhttp3.OkHttpClient;

public class Milanpetstoresdk {

  public PetsService petsService;

  public Milanpetstoresdk() {
    final String serverUrl = Environment.DEFAULT.getUrl();
    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor())
      .addInterceptor(new RetryInterceptor())
      .build();

    this.petsService = new PetsService(httpClient, serverUrl);
  }

  public void setBaseUrl(String url) {
    this.petsService.setBaseUrl(url);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
