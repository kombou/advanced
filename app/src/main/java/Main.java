import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.orion.app.server.Server;

import javax.servlet.ServletException;
import java.io.File;

public class Main {


    public static void main(String argv[]) {
        Server.getServer().start();
    }
}
