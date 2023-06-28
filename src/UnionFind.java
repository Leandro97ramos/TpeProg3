
public class UnionFind {
    private int[] parent;
    private int[] rank;
    private int componentesConectados;

    public UnionFind(int cantidadVertices) {
        parent = new int[cantidadVertices];
        rank = new int[cantidadVertices];
        componentesConectados = cantidadVertices;

        for (int i = 0; i < cantidadVertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {
            componentesConectados--;
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    public int componentesConectados() {
        return componentesConectados;
    }
}
