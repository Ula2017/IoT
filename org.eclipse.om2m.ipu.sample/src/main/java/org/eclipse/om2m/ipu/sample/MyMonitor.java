package org.eclipse.om2m.ipu.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MyMonitor implements Runnable {

    public void run() {

        HttpServer server = null;
        try {
            int aePort = 1600;
            server = HttpServer.create(new InetSocketAddress(aePort), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert server != null;
        server.createContext("/", new MyHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
    }

    static class MyHandler implements HttpHandler {

        public static int temperature = 0;

        public void handle(HttpExchange httpExchange)  {
            System.out.println("Event Recieved!");

            try{
                InputStream in = httpExchange.getRequestBody();

                String requestBody = "";
                int i;char c;
                while ((i = in.read()) != -1) {
                    c = (char) i;
                    requestBody = requestBody + c;
                }

                JSONObject json = new JSONObject(requestBody);

                if (json.getJSONObject("m2m:sgn").has("m2m:vrq")) {
                    System.out.println("Confirm subscription");
                } else {
                    JSONObject rep = json.getJSONObject("m2m:sgn").getJSONObject("m2m:nev")
                            .getJSONObject("m2m:rep").getJSONObject("m2m:cin");
                    int ty = rep.getInt("ty");

                    if(ty == 4){
                        MyHandler.temperature = rep.getInt("con");
                        System.out.println("[INFO] TEMPERATURE: "+MyHandler.temperature );
                    }
                }
                String responseBody ="";
                byte[] out = responseBody.getBytes("UTF-8");
                httpExchange.sendResponseHeaders(200, out.length);
                OutputStream os = httpExchange.getResponseBody();
                os.write(out);
                os.close();

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}