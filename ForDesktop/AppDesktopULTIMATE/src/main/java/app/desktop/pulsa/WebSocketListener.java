
package app.desktop.pulsa;


public interface WebSocketListener {
    void onOpen();
    void onClose();
    void onError();
    void onMessage(String message);
}
