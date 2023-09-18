import java.util.Random;

public class ListaDobleEnlazada {

    Nodo cabeza;
    Nodo cola;
    Event eventoA = null;
    Event eventoB = null;
    Event eventoC = null;

    ListaDobleEnlazada() {
        cabeza = null;
        cola = null;
    }

    public boolean vacio() {
        return cabeza == null;
    }

    public boolean sonCoprimos(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int resultado = 0;

        do {
            resultado = min;
            min = max % min;
            max = resultado;
        } while (min != 0);

        return max == 1;
    }

    public boolean esPrimo(int numero) {
        if (numero == 1) {
            return false;
        }

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void empezar() {
        int contadorEventoA = 0;
        int contadorEventoB = 0;
        int contadorEventoC = 0;
        int contadorNodos = 0;
        Nodo ultimoNodo = null;

        for (int i = 1; i <= 22; i++) {
            if (!vacio()) {
                contadorNodos++;
                Randoms numero = new Randoms();
                String cientifico = numero.getCientifico();
                int dato = numero.getNumero();

                Event nuevoEvento = new Event(dato, cientifico);

                boolean datob = esPrimo(dato);

                if (datob && contadorEventoA == 0) {
                    nuevoEvento.setEventType("Evento A");
                    nuevoEvento.setScientist("Einstein");
                    eventoA = nuevoEvento;
                    contadorEventoA = 1;

                    System.out.println("Se ha producido un evento de Tipo A:" + dato);
                    System.out.println("Este evento reposa en el nodo:" + contadorNodos);
                    nuevoEvento.displayEvent();
                    System.out.println("\n");
                } else if (datob && eventoA != null && contadorEventoB == 0) {
                    nuevoEvento.setEventType("Evento B");
                    eventoB = nuevoEvento;
                    contadorEventoB = 1;

                    System.out.println("Se ha producido un evento de Tipo B:" + dato);
                    System.out.println("Este evento reposa en el nodo:" + contadorNodos);
                    nuevoEvento.displayEvent();
                    System.out.println("\n");

                    contadorEventoC = 0;
                } else if (eventoA != null && eventoB != null && sonCoprimos(dato, eventoA.getData()) && contadorEventoC == 0) {
                    nuevoEvento.setEventType("Evento C");
                    contadorEventoC = 1;

                    System.out.println("Se ha producido un evento de Tipo C:" + dato);
                    System.out.println("Este evento reposa en el nodo:" + contadorNodos);
                    nuevoEvento.displayEvent();
                    System.out.println("\n");

                    if (esPrimo(dato) && eventoA.getScientist().equals("Einstein")) {
                        System.out.println("El científico " + nuevoEvento.getScientist() + " viajó al pasado y entregó datos clave para el avance del proyecto a " + eventoA.getScientist());
                        System.out.println("[" + eventoA.getData() + "|" + eventoA.getScientist() + "|" + eventoA.getEventType() + "]" + " <= " + "[" + eventoB.getData() + "|" + eventoB.getScientist() + "|" + eventoB.getEventType() + "]" + " <= " + "[" + nuevoEvento.getData() + "|" + nuevoEvento.getScientist() + "|" + nuevoEvento.getEventType() + "]");
                        System.out.println("\n");
                    } else {
                        System.out.println("El científico " + nuevoEvento.getScientist() + " viajó al pasado, pero solo pudo observar");
                        System.out.println("[" + eventoA.getData() + "|" + eventoA.getScientist() + "|" + eventoA.getEventType() + "]" + " <= " + "[" + eventoB.getData() + "|" + eventoB.getScientist() + "|" + eventoB.getEventType() + "]" + " <= " + "[" + nuevoEvento.getData() + "|" + nuevoEvento.getScientist() + "|" + nuevoEvento.getEventType() + "]");
                        System.out.println("\n");
                    }
                }

                Nodo nuevoNodo = new Nodo(nuevoEvento, null, null);

                if (ultimoNodo != null) {
                    ultimoNodo.next = nuevoNodo;
                    nuevoNodo.prev = ultimoNodo;
                } else {
                    cabeza = nuevoNodo;
                    cola = nuevoNodo;
                }

                ultimoNodo = nuevoNodo;
            } else {
                Randoms numero = new Randoms();
                int dato = numero.getNumero();
                String cientifico = numero.getCientifico();

                Event nuevoEvento = new Event(dato, cientifico);

                cabeza = cola = new Nodo(nuevoEvento, null, null);
                contadorNodos++;
                ultimoNodo = cabeza;
            }
        }
    }

    public void imprimir_Lista() {
        if (!vacio()) {
            String datos = "<=";

            Nodo ayudante = cabeza;

            while (ayudante != null) {
                datos = datos + "[" + ayudante.getEvent().getData() + "|" + ayudante.getEvent().getScientist() + "|" + ayudante.getEvent().getEventType() + "]<=";
                ayudante = ayudante.next;
            }

            System.out.println("Datos" + datos);
        }
    }
}
