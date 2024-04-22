package io.github.mlanlazc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Environment {
  DEFAULT("https://eox352uelardliu.m.pipedream.net");

  private final String url;

  public String getUrl() {
    return this.url;
  }
}
