package org.orion.app.server;

public class Server {

    private static Server server;

    private Server() {

    }

    public static Server getServer() {
        if (server == null) server = new Server();
        return server;
    }

    public void start() {

        AppServer appServer = new TomcatServer();
        appServer.create();
        appServer.configure();
        appServer.start();
    }
}
