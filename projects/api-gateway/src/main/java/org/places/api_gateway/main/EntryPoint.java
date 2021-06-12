package org.places.api_gateway.main;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.places.api_gateway.config.Settings;
import org.places.api_gateway.service.ApiGatewayService;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class EntryPoint {

  private static ApiGateway apiGateway;

  public static ApiGateway getApiGateway() {
    return apiGateway;
  }

  private static void initApiGateway(Settings settings) {
    apiGateway = new ApiGateway(settings);
  }

  private static void runApiGateway() throws IOException {
    ResourceConfig rcWork = new ResourceConfig(ApiGatewayService.class);

    URI apiGatewayServiceUri =
        UriBuilder.fromUri("http://0.0.0.0")
            .port(apiGateway.getSettings().getApiGatewayPort())
            .build();
    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(apiGatewayServiceUri, rcWork);
    server.start();
  }

  public static void main(String[] args) {
    Settings settings = new Settings();
    settings.parse(args);
    try {
      initApiGateway(settings);
      runApiGateway();
    } catch (Exception e) {
      // TODO: log warning
      e.printStackTrace();
    }
  }
}
