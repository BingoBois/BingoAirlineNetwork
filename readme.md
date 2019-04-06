# Bingobois Airline Network
Assignment with focus on building source directed graph using Airline Network data.

### Implementation

Started out the assignment doing super generic setups for everything, including the Vertexes and the data they store. It seemed really smart, but we found out that every algorithm is tightly tied into the datatype and way you store it. After wasting way too much time, we decided to basically just have speific graphs/data type for each assignment.


The graph we use is similar to an "Array of adjacency list", but since we're storing data that isn't integer, we use source hashmap for lookup. (Instead of indexes).


### DepthFirst

We had issues with DepthFirst - considering its nature of traversing almost random routes, till it reaches its end goal, or source dead end, where it then backtracks. It would crash - because of source stackoverflow error that ocurred, due to the size of the data set provided. When using source smaller dataset (40k lines, instead of 65k lines) we got acceptable results, without crashes.

# Choice of datastructures


## Adjencency List 

**Graph**: Adjencency list where we utilize hashmaps instead of an array to store non-integer values, but still need a way to index items so that we can lookup at any given time.

**Space**: We store all verteces and edges, in that case it becomes `O(E + V)`

**Adding**: To add an edge, we put the given element into the hashmap, making it `O(1)` 

**Is there an edge between A and B?**: We have to iterate through all possible edges on a specific vertece, to find the right edge making it `O(degree(v))`, where degree is the amount of edges on a vertece.

**Look up**: Since we're using hashmaps, we can look up any item given it's identifier. This makes it `O(n)`

## Depth First
**(For unvisited edges) Insertion / Popping** : To store all unvisited verteces, we store them in a stack (Making it last in, first out). If we were to use normal lists, the difference wouldn't change, as we still loop through every element in that same stack.

**Searching**: Worst case scenario in this case would be `O(V)`

## Breadth First
**(For unvisited edges) Insertion / Deletion** : To store all unvisited verteces, we use a priorityqueue which is a minimumheap, based on a certain factor (In this case, the distance / jumps away). For insertions / deletions, it's `O(log(n))` and finding the smallest is `O(1)` since heaps keeps the smallest element at the top, making it easily accesible. Without the priorityqueue, we would end up with a standard scenario of `O(n)`, since we can no longer rely on the first element being the one we need for the scenario, but we would have instead have to look up every element in the list.

**Look up**: Finding the given element is `O(n)`, since it's based around the same structure for storing as our adjency lists (hashmaps).

**Worst Case Searching**: We have to go through all possible edges for all
## Dickstra

**(For unvisited edges) Insertion / Deletion** : To store all unvisited verteces, we use a priorityqueue which is a minimumheap, based on a certain factor (In this case, the weight). For insertions / deletions, it's `O(log(n))` and finding the smallest is `O(1)` since heaps keeps the smallest element at the top, making it easily accesible. Without the priorityqueue, we would end up with a standard scenario of `O(n)`, since we can no longer rely on the first element being the one we need for the scenario, but we would have instead have to look up every element in the list.

## MST (Primm)
**(For unvisited edges) Insertion / Deletion** : To store all unvisited verteces, we use a priorityqueue which is a minimumheap, based on a certain factor (In this case, the weight). For insertions / deletions, it's `O(log(n))` and finding the smallest is `O(1)` since heaps keeps the smallest element at the top, making it easily accesible. Without the priorityqueue, we would end up with a standard scenario of `O(n)`, since we can no longer rely on the first element being the one we need for the scenario, but we would have instead have to look up every element in the list. 

# Adjecency List vs Adjecency Matrix

Using this would make the size `O(e^2)`. We didn't have the time to measure this, so we base it on speculation.

## Links
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_11/slides/07_Graphs_1.pdf
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_12/slides/07_Graphs_2.pdf
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_13/slides/07_Graphs_3_ShortestPaths.pdf
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_13/slides/07_Graphs_3_MSTs.pdf

https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_11/04-assignment/04%20Assignment%20Airline%20Network.pdf
