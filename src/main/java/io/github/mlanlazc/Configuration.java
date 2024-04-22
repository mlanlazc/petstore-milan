package io.github.mlanlazc;

public class Configuration {

  public static final String USER_AGENT = "Milanpetstoresdk/1.0.0 Java/" + getJavaVersion();

  public static final String DEFAULT_API_KEY_HEADER = "X-API-KEY";

  private static String getJavaVersion() {
    return System.getProperty("java.version");
  }
}
