/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF uf;
    private int N;
    private int openSites;
    private boolean opened[];

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        uf = new WeightedQuickUnionUF(n * n + 2);
        opened = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) {
            uf.union(0, i); // create the first virtual node connected to first row
        }
        for (int i = n * (n - 1) + 1; i <= n * n; i++) {
            uf.union(n * n + 1, i); // create the last virtual node connected to last row
        }
        N = n;
        openSites = 0;
    }

    private int getIndex(int row, int col) {
        if (row <= 0 || row > N || col <= 0 || col > N)
            throw new IllegalArgumentException();
        return N * (row - 1) + col;
    }

    private int[] getNeighbors(int index) {
        // left right up down
        int[] neighborsTemp = { index - 1, index + 1, index - N, index + N };
        int[] neighbors = new int[4];
        int i = 0;
        for (int element : neighborsTemp) {
            if (element > 0 && element <= N * N) {
                if (index % N == 0 && element == index + 1)
                    continue;
                else if (element == index - 1 && element % N == 0)
                    continue;
                neighbors[i] = element;
                i++;
            }
        }
        return neighbors;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = getIndex(row, col);
        opened[index] = true;
        int[] neighbors = getNeighbors(index);

        for (int element : neighbors) {
            if (element == 0)
                continue;
            if (opened[element]) {
                uf.union(index, element); // union between the index and the neighbor
            }
        }
        openSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = getIndex(row, col);
        return opened[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isOpen(row, col))
            return false;
        int index = getIndex(row, col);
        return uf.find(0) == uf.find(index);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return (uf.find(0) == uf.find(N * N + 1));
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(2, 1);
        System.out.println("ldjlds");
    }
}
