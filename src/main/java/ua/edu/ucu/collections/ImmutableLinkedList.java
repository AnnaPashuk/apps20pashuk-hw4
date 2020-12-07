package ua.edu.ucu.collections;

public class ImmutableLinkedList implements ImmutableList{

    private Object[] list;
    private Node start;
    private Node end;
    private int size;


    public ImmutableLinkedList(){
        start = new Node(null);
    }

    public ImmutableLinkedList(Object[] list){
        this.size = list.length;

        this.start = new Node(list[0]);
        end = start;
        for (int i = 0; i < list.length; i ++){
            Node newNode = new Node(list[i]);
            end = newNode;
        }
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] newList = new Object[this.size + 1];
        newList[0] = e;
        if(newList.length > 1){
            for (int i=1; i < list.length + 1; i ++){
                newList[i] = list[i-1];
            }
        }
        return new ImmutableLinkedList(newList);
    }

    public ImmutableLinkedList addLast(Object e) {
        if (list == null){
            size = 0;
        }
        else {
            size = list.length;
        }
        Object[] newList = new Object[this.size + 1];
        if(newList.length > 0){
            for (int i = 0; i < size; i ++){
                newList[i] = list[i];
            }
        }
        newList[this.size] = e;
        return new ImmutableLinkedList(newList);
    }

    public Object getFirst(){
        if(this.isEmpty()){
            return null;
        }
        return this.start.get();
    }
    public Object getLast(){
        if(this.isEmpty()){
            return null;
        }
        return this.end.get();
    }

    public ImmutableLinkedList removeFirst() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("Empty list");
        }
        else if(this.size == 1){
            return new ImmutableLinkedList();
        }
        Object[] newList = new Object[this.size - 1];
        if (list == null){
            size = 0;
        }
        else {
            size = list.length;
        }
        for (int i = 0; i < size - 1; i ++){
            newList[i] = list[i + 1];
        }
        return new ImmutableLinkedList(newList);
    }

    public ImmutableLinkedList removeLast(){
        if (this.isEmpty()){
            throw new IllegalArgumentException("Empty list");
        }
        else if(this.size == 1){
            return new ImmutableLinkedList();
        }
        Object[] newList = new Object[this.size - 1];
        for (int i = 0; i < list.length - 1; i ++){
            newList[i] = list[i];
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList add(Object e) {
        return addLast(e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] elems = {e};
        return addAll(index, elems);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }



}
