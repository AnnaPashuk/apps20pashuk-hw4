package ua.edu.ucu.iterators;

import ua.edu.ucu.collections.Queue;

public class WordsRepository implements Container {
    private Queue queue;

    public WordsRepository(Queue queue){
        this.queue = queue;
    }

    @Override
    public MyIterator<String> getIterator() {
        return new WordsIterator(queue);
    }

    private class WordsIterator implements MyIterator<String> {
        private Queue queue;
        public WordsIterator(Queue queue){
            this.queue = queue;
        }
        @Override
        public boolean hasNext() {
            if(!queue.isEmpty()){
                return true;
            }

            return false;
        }

        @Override
        public String next() {
            String str = (String) queue.dequeue();
            return str;
        }
    }
}
