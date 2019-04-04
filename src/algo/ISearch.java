package algo;

import algo.Opg1DepthFirst.NoPathException;

import java.util.ArrayList;

public interface ISearch<T extends Comparable<T>> {
    public ArrayList<String> search(String start, String end) throws NoPathException;
}
