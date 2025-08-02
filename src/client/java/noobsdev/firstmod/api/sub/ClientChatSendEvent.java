package noobsdev.firstmod.api.sub;

public class ClientChatSendEvent {
    private final String message;
    private boolean canceled = false;

    public ClientChatSendEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}