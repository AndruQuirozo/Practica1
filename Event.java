public class Event {
    int data; 
    String scientist; 
    String eventType; 
    Event next;
    Event prev;

    Event(int data, String scientist) {
        this.data = data;
        this.scientist = scientist;
        this.eventType = "";
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public String getScientist() {
        return scientist;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setScientist(String scientist) {
        this.scientist = scientist;
    }

    public void displayEvent() {
        System.out.println("[" + data + "|" + scientist + "|" + eventType + "]");
    }
}

