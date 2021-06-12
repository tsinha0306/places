package org.places.api_gateway.config;

import org.apache.commons.cli.*;

import javax.annotation.Nonnull;

import static com.google.common.base.MoreObjects.firstNonNull;

/** Class to store settings for initializing the cluster */
public class Settings {
  private static final String PORT = "port";


  private Integer apiGatewayPort;
  private Options options;

  public Settings() {
    options = new Options();
    options
        .addOption("p", PORT, true, "Port for the Nebula storage service");
  }

  public void parse(String[] args) {
    CommandLineParser parser = new DefaultParser();
    CommandLine line = null;
    try {
      line = parser.parse(options, args);
    } catch (ParseException e) {
      help();
    }
    assert line != null;
    apiGatewayPort = firstNonNull(getIntValue(PORT, line), 2501);
  }

  public Integer getApiGatewayPort() {
    return apiGatewayPort;
  }

  public void setApiGatewayPort(Integer apiGatewayPort) {
    this.apiGatewayPort = apiGatewayPort;
  }

  public Options getOptions() {
    return options;
  }


  private Integer getIntValue(@Nonnull String optionName, @Nonnull CommandLine cmd) {
    if (cmd.hasOption(optionName)) {
      try {
        return Integer.parseInt(cmd.getOptionValue(optionName));
      } catch (NumberFormatException e) {
        // TODO: add logging for errors
        return null;
      }
    }
    return null;
  }

  private String getStringValue(@Nonnull String optionName, @Nonnull CommandLine cmd) {
    if (cmd.hasOption(optionName)) {
      return cmd.getOptionValue(optionName);
    }
    return null;
  }

  private void help() {
    // print help
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("ApiGateway", options);
    System.exit(0);
  }
}
