package search.Dijkstra;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {
    private ArrayList<DKData<T>> heap;

    public MinHeap(){
        heap = new ArrayList<DKData<T>>();
    }

    public void enqueue(Object item) {
        DKData<T> current = (DKData<T>) item;
        heap.add(current);
        swapWithParent(current, heap.size() -1);
    }

    public Object dequeue() {
        // Remove root
        if(heap.size() == 0){
            throw new NoSuchElementException("Queue is empty!");
        }
        DKData<T> oldRoot = heap.get(0);
        DKData<T> newest = heap.get(heap.size() - 1);
        heap.set(0, newest);
        heap.remove(heap.size() - 1);
        swapWithChild(0);
        return oldRoot;
    }

    public Object peek() {
        if(heap.size() > 0){
            return heap.get(0);
        }
        throw new NoSuchElementException("No elements in the heap");
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return (heap.size() == 0);
    }

    public ArrayList<DKData<T>> getHeap(){
        return this.heap;
    }

    private void swapWithChild(int parentIndex){
        // compare x with biggest of y or z
        int leftChildIndex = parentIndex * 2;
        int rightChildIndex = (parentIndex * 2) + 1;
        if(heap.size() -1 >= rightChildIndex){
            int comparison = heap.get(leftChildIndex).compareTo(heap.get(rightChildIndex));
            int biggestChildIndex = leftChildIndex;
            if (comparison < 0){
                biggestChildIndex = rightChildIndex;
            }
            DKData<T> tmpPassenger = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(biggestChildIndex));
            heap.set(biggestChildIndex, tmpPassenger);
            swapWithChild(biggestChildIndex);
        }
    }

    private void swapWithParent(DKData<T> current, int currentIndex){
        int parentIndex = (int) Math.floor(currentIndex / 2);
        if(parentIndex >= 0){
            DKData<T> parent = heap.get(parentIndex);
            int comparison = current.compareTo(parent);
            if (comparison > 0){
                DKData<T> tmpPassenger = parent;
                heap.set(parentIndex, current);
                heap.set(currentIndex, tmpPassenger);
                swapWithParent(current, parentIndex);
            }
        }
    }

    public boolean contains(DKData<T> data){
        for(DKData<T> d : heap){
            if(d.equals(data)){
                return true;
            }
        }
        return false;
    }
}
