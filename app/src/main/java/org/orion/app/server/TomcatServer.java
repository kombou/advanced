package org.orion.app.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer extends ServerAbstract implements AppServer {

    private Tomcat tomcat;

    @Override
    public void create() {
        System.setProperty("tomcat.util.scan.StandardJarScanFilter.jarsToSkip", "*.jar");
        tomcat = new Tomcat();
    }

    @Override
    public void configure() {
        tomcat.setPort(this.PORT);
        try {

            Context context = tomcat.addWebapp(APP_BASE_URL,new File( WEB_DIR ).getAbsolutePath());
            File classDir = new File(OUTPUT_DIR);
            WebResourceRoot resourceRoot = new StandardRoot(context);
            resourceRoot.addPreResources(new DirResourceSet(resourceRoot,WEB_APP_MOUNT_DIR,classDir.getAbsolutePath(), BASE_PATH ));
            context.setResources(resourceRoot);

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {

            tomcat.getConnector();
            tomcat.start();
            tomcat.getServer().await();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
