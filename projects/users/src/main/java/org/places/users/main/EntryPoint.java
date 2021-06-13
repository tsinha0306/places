package org.places.users.main;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.places.users.config.Settings;
import org.places.users.service.UsersService;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class EntryPoint {

    private static Users Users;

    public static Users getUsers() {
        return Users;
    }

    private static void initUsers(Settings settings) {
        Users = new Users(settings);
    }

    private static void runUsers() throws IOException {
        ResourceConfig rcWork = new ResourceConfig(UsersService.class);

        URI UsersServiceUri =
                UriBuilder.fromUri("http://0.0.0.0")
                        .port(Users.getSettings().getUsersPort())
                        .build();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(UsersServiceUri, rcWork);
        server.start();
    }

    public static void main(String[] args) {
        Settings settings = new Settings();
        settings.parse(args);
        try {
            initUsers(settings);
            runUsers();
        } catch (Exception e) {
            // TODO: log warning
            e.printStackTrace();
        }
    }
}


