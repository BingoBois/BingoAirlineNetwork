# Bingobois Airline Network
Assignment with focus on building a directed graph using Airline Network data.

### Implementation

Started out the assignment doing super generic setups for everything, including the Vertexes and the data they store. It seemed really smart, but we found out that every algorithm is tightly tied into the datatype and way you store it. After wasting way too much time, we decided to basically just have speific graphs/data type for each assignment.


The graph we use is similar to an "Array of adjacency list", but since we're storing data that isn't integer, we use a hashmap for lookup. (Instead of indexes).


### DepthFirst

We had issues with DepthFirst - considering its nature of traversing almost random routes, till it reaches its end goal, or a dead end, where it then backtracks. It would crash - because of a stackoverflow error that ocurred, due to the size of the data set provided. When using a smaller dataset (40k lines, instead of 65k lines) we got acceptable results, without crashes.



## Links
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_11/slides/07_Graphs_1.pdf
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_12/slides/07_Graphs_2.pdf
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_13/slides/07_Graphs_3_ShortestPaths.pdf
https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_13/slides/07_Graphs_3_MSTs.pdf

https://github.com/datsoftlyngby/soft2019spring-algorithms/blob/master/Weeklies/Week_11/04-assignment/04%20Assignment%20Airline%20Network.pdf
