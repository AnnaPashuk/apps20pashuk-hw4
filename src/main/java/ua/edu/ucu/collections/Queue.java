package ua.edu.ucu.collections;


import ua.edu.ucu.iterators.WordsRepository;

import ua.edu.ucu.iterators.MyIterator;

public class Queue implements Iterable<String>{
    private ImmutableLinkedList list;
    public Queue(){
        list = new ImmutableLinkedList();
    }
    public Object peek(){
        return list.getFirst();
    }
    public Object dequeue(){
        Object first = list.getFirst();
        list = list.removeFirst();
        return first;
    }
    public void enqueue(Object e){
        list = list.addLast(e);
    }

    @Override
    public MyIterator<String> iterator() {
        WordsRepository wordsRepository = new WordsRepository(this);
        return wordsRepository.getIterator();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}

