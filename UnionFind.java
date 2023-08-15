/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class UnionFind {

    private int[] id;
    private int[] sz;

    // Quick union algorithm
    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        Arrays.fill(sz, 1);
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) // because the root parent is his self
        {
            id[i] = id[id[i]]; // the parent of i becomes the parent of its parent
            // in order to reach the root
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        // the smaller tree is absorbed by the bigger one
        // in order to avoid long trees
        // we can use the depth of the tree instead of the size
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] = sz[j];
        }

    }

    public static void main(String[] args) {

    }
}
