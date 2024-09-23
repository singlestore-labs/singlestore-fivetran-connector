package com.singlestore.fivetran.connector;

import io.grpc.*;

import java.io.IOException;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleStoreConnector {
  private static final Logger logger = LoggerFactory.getLogger(SingleStoreConnector.class);

  public static void main(String[] args) throws InterruptedException, IOException, ParseException {
    Options options = new Options();
    Option portOption = new Option("p", "port", true, "port which server will listen");
    options.addOption(portOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd = null;

    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      logger.error("Failed to parse arguments", e);
      formatter.printHelp("singlestore-fivetran-connector", options);

      throw e;
    }

    String portStr = cmd.getOptionValue("port", "50052");
    int port = 50051;
    try {
      port = Integer.parseInt(portStr);
    } catch (NumberFormatException e) {
      logger.warn("Failed to parse --port option", e);
      formatter.printHelp("singlestore-fivetran-connector", options);

      throw e;
    }

    logger.info(
        String.format("Starting Connector gRPC server (version %s) which listens port %d",
            VersionProvider.getVersion(), port));
    Server server = ServerBuilder.forPort(port)
        .addService(new SingleStoreConnectorServiceImpl()).build();

    server.start();
    logger.info(String.format("Connector gRPC server started"));
    server.awaitTermination();
  }
}
