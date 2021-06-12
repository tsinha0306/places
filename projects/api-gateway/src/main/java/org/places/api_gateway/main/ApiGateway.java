package org.places.api_gateway.main;

import org.places.api_gateway.config.Settings;

public class ApiGateway {
  private final Settings settings;

  public ApiGateway(Settings settings) {
    this.settings = settings;
  }

  public Settings getSettings() {
    return settings;
  }
}
