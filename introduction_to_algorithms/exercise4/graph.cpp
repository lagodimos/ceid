#include <iostream>
#include <list>
#include <string>
#include <vector>
using namespace std;

#define TREE_EDGES 0
#define FORWARD_EDGES 1
#define BACK_EDGES 2
#define CROSS_EDGES 3

void displayGraph(list<int> graph[], int v);
void insert_edge(list<int> graph[], int u, int v);

void dfs(list<int> graph[], int vertices);
int dfs_visit(int t, list<int> graph[], int vertices, vector<vector<int>> *discovered_finished, vector<vector<int>> edges[], int v);

list<int> even_odd_sort(list<int> nums);

int main(int argc, char *argv[]) {
    int v = 10; // Number of vertices (+1 if 1-based indexing)

    // Create an adjacency list representation of the graph
    list<int> graph[v];

    // Insert edges
    insert_edge(graph, 1, 2);
    insert_edge(graph, 1, 4);
    insert_edge(graph, 1, 5);
    insert_edge(graph, 2, 3);
    insert_edge(graph, 2, 6);
    insert_edge(graph, 3, 5);
    insert_edge(graph, 3, 7);
    insert_edge(graph, 4, 6);
    insert_edge(graph, 4, 8);
    insert_edge(graph, 5, 4);
    insert_edge(graph, 5, 6);
    insert_edge(graph, 5, 9);
    insert_edge(graph, 6, 7);
    insert_edge(graph, 6, 9);
    insert_edge(graph, 7, 2);
    insert_edge(graph, 7, 8);
    insert_edge(graph, 8, 1);
    insert_edge(graph, 8, 9);
    insert_edge(graph, 9, 3);
    insert_edge(graph, 9, 4);
    insert_edge(graph, 9, 7);

    dfs(graph, v);

    return 0;
}

void displayGraph(list<int> graph[], int v) {
    for (int i = 1; i < v; i++) { // start from 1 if it's 1-based
        cout << i << " ---> ";
        for (auto it = graph[i].begin(); it != graph[i].end(); ++it) {
            cout << *it << " ";
        }
        cout << endl;
    }
}

void insert_edge(list<int> graph[], int u, int v) {
    graph[u].push_back(v);  // Add edge u -> v
}

void dfs(list<int> graph[], int vertices) {
    int t = 1;
    vector<vector<int>> edges[4];

    vector<vector<int>> discovered_finished;
    for (int v = 0; v < vertices; v++) {
        discovered_finished.push_back({-1, -1});
    }

    for (int v = 1; v < vertices; v++) {
        if (discovered_finished[v][0] < 0) {
            t = dfs_visit(t, graph, vertices, &discovered_finished, edges, v);
        }
    }

    string edge_types[] = {"Tree Edges", "Forward Edges", "Back Edges", "Cross Edges"};
    for (int i=0; i < 4; i++) {
        cout << edge_types[i] << endl;
        for (int j=0; j < edges[i].size(); j++) {
            cout << edges[i][j][0] << " " << edges[i][j][1] << endl;
        }
    }
}

int dfs_visit(int t, list<int> graph[], int vertices, vector<vector<int>> *discovered_finished, vector<vector<int>> edges[], int v) {
    t++;
    (*discovered_finished)[v][0] = t;

    auto vert = even_odd_sort(graph[v]);
    for (auto it = vert.begin(); it != vert.end(); ++it) {
        if ((*discovered_finished)[*it][0] < 0) {
            edges[TREE_EDGES].push_back({v, *it});
            t = dfs_visit(t, graph, vertices, discovered_finished, edges, *it);
        }
        else if ((*discovered_finished)[*it][1] < 0) {
            edges[BACK_EDGES].push_back({v, *it});
        }
        else if ((*discovered_finished)[v][0] < (*discovered_finished)[*it][0]) {
            edges[FORWARD_EDGES].push_back({v, *it});
        }
        else {
            edges[CROSS_EDGES].push_back({v, *it});
        }
    }

    t++;
    (*discovered_finished)[v][1] = t;

    return t;
}

list<int> even_odd_sort(list<int> nums) {
    list<int> even, odd;

    for (auto it=nums.begin(); it != nums.end(); ++it) {
        if ((*it) % 2 == 0) {
            even.push_back(*it);
        }
        else {
            odd.push_back(*it);
        }
    }
    even.sort();
    odd.sort();
    even.splice(even.end(), odd);

    return even;
}

/* answer
Tree Edges
1 2
2 6
6 7
7 8
8 9
9 4
9 3
3 5
Forward Edges
1 4
1 5
2 3
6 9
Back Edges
3 7
4 6
4 8
5 6
5 9
7 2
8 1
9 7
Cross Edges
5 4 */
