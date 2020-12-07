package ua.edu.ucu.collections;

public class Node {
    private Object data;
    private Node nextNode;

    public Node(Object d) {
        this.data = d;
    }

    public Object get() {
        return data;
    }

    public void set(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return nextNode;
    }

    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node copy(){
        return new Node(data);
    }



}
