/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.pulsa.destop;

import java.net.URI;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

/**
 *
 * @author Ardiyan
 */
public class SmsGatewayClient extends WebSocketClient {
    private final WebSocketListener listener;
 public SmsGatewayClient(URI serverURI, WebSocketListener listener) {
 super(serverURI);
 this.listener = listener;
 }
 public void onOpen(ServerHandshake handshakedata) {
     listener.onOpen();
 }
 public void onMessage(String message) {
     listener.onMessage(message);
 }
 public void onClose(int code, String reason, boolean remote) {
     listener.onClose();
 }
 public void onError(Exception ex) {
    listener.onError();
}

}
