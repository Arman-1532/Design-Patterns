import java.util.*;

interface EventListeners {
    void update(String filename);
}

class EmailAlertsListener implements EventListeners {
    private String email;

    public EmailAlertsListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String filename) {
        System.out.println("Email to " + email + ": Someone has changed the file -> " + filename);
    }
}

class LoggingListener implements EventListeners {
    private String logFile;

    public LoggingListener(String logFile) {
        this.logFile = logFile;
    }

    @Override
    public void update(String filename) {
        System.out.println("Log entry to " + logFile + ": File changed -> " + filename);
    }
}

class EventManager {
    private Map<String, List<EventListeners>> listeners = new HashMap<>();

    public EventManager(String... eventTypes) {
        for (String type : eventTypes) {
            listeners.put(type, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListeners listener) {
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListeners listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType, String data) {
        List<EventListeners> users = listeners.get(eventType);
        for (EventListeners listener : users) {
            listener.update(data);
        }
    }
}

class Editor {
    public EventManager events;
    private String filename;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile() {
        this.filename = "test_document.txt";
        System.out.println("Opening the file: " + filename);
        events.notify("open", filename);
    }

    public void saveFile() {
        System.out.println("Saving the file: " + filename);
        events.notify("save", filename);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Editor editor = new Editor();

        EmailAlertsListener emailListener = new EmailAlertsListener("admin@example.com");
        LoggingListener logListener = new LoggingListener("/log/file_changes.txt");

        editor.events.subscribe("open", emailListener);
        editor.events.subscribe("save", logListener);

        editor.openFile();
        editor.saveFile();
    }
}
