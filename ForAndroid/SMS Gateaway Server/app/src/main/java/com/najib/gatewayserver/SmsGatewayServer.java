package com.najib.gatewayserver;

import org.apache.http.HttpException;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SmsGatewayServer {
    private int port;
    private HttpService httpService;
    private ServerSocket serverSocket;
    private HttpContext httpContext;

    public SmsGatewayServer(int port) {
        this.port = port;
        httpService = new HttpService(new BasicHttpProcessor(),
                new DefaultConnectionReuseStrategy(),
                new DefaultHttpResponseFactory());
        httpContext = new BasicHttpContext();

        // tambahkan handler
        HttpRequestHandlerRegistry registry = new HttpRequestHandlerRegistry();
        registry.register("*", new SmsGatewayHandler());
        httpService.setHandlerResolver(registry);


    }

    public void start() throws IOException, HttpException {
// membuat server socket berdasarkan port
        serverSocket = new ServerSocket(port);
        while (true) {
// terima socket client jika ada request masuk
            Socket socket = serverSocket.accept();
// handle request sebagai HTTP Request
            DefaultHttpServerConnection sCon = new DefaultHttpServerConnection();
            sCon.bind(socket, new BasicHttpParams());
            httpService.handleRequest(sCon, httpContext);
// close koneksi client
            socket.close();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
}
