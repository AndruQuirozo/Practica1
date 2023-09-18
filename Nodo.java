public class Nodo {
    Nodo prev;
    Event event;
    Nodo next;

    Nodo(Event event) {
        this.prev = null;
        this.event = event;
        this.next = null;
    }

    Nodo(Event event, Nodo prev, Nodo next) {
        this.prev = prev;
        this.event = event;
        this.next = next;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }

    public void imprimirSiguiente() {
        System.out.println(this.next.getEvent().getData());
    }
}

