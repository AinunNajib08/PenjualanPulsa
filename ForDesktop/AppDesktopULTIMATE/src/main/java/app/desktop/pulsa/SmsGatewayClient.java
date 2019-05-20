
package app.desktop.pulsa;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
public class SmsGatewayClient extends WebSocketClient{

    private final WebSocketListener listener;
    public SmsGatewayClient(URI serverURI, WebSocketListener listener) {
        super(serverURI);
        this.listener = listener;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        listener.onOpen();
    }

    @Override
    public void onMessage(String message) {
        listener.onMessage(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        listener.onClose();
    }

    @Override
    public void onError(Exception ex) {
        listener.onError();
    }
}
