#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class heap {
    vector<int> myHeapVector;

    public:
        int heapSize() {
            return myHeapVector.size() - 1;
        }

        void myHeap(vector<int> intVector) {
            myHeapVector = intVector;
        }

        int at(int idx) {
            return myHeapVector[idx];
        }

        void printItems() {
            cout << "Heap Vector:" << endl;

            for (int i = 1; i < myHeapVector.size(); i++) {
                cout << myHeapVector[i] << " ";
            }

            cout << endl << endl;
        }

        int extractRoot() {
            int root = myHeapVector[1];
            swap(myHeapVector[1], myHeapVector.back());
            myHeapVector.pop_back();

            myHeapifyDown(1);

            return root;
        }

        void insertItem(int item) {
            myHeapVector.push_back(item);
            myHeapifyUp(heapSize());
        }

        int myHeapifyDown(int i) {
            int j;
            int itemValue = myHeapVector[i];

            if (2*i > heapSize()) {
                return i;
            }
            else if (2*i == heapSize()) {
                j=2*i;
            }
            else {
                int left = 2*i;
                int right = 2*i + 1;
                myHeapVector[left] <= myHeapVector[right] ? j = left : j = right;
            }

            if (myHeapVector[j] < myHeapVector[i]) {
                swap(myHeapVector[j], myHeapVector[i]);
                cout << "myHeapifyDown: Moved " << itemValue << " to position " << j << endl;
                printItems();
                int final_pos = myHeapifyDown(j);
                return final_pos;
            }
            else {
                return i;
            }
        }

        int myHeapifyUp(int i) {
            int parentIdx = i/2;
            int itemValue = myHeapVector[i];

            if (i > 1 && myHeapVector[i] < myHeapVector[parentIdx]) {
                swap(myHeapVector[i], myHeapVector[parentIdx]);
                cout << "myHeapifyUp: Moved " << itemValue << " to position " << parentIdx << endl;
                printItems();
                int final_pos = myHeapifyUp(parentIdx);
                return final_pos;
            }
            else {
                return i;
            }
        }
};

class answer {
    vector<int> numbers;
    heap myheap;

    public:
        void readFile() {
            int num;
            ifstream inputFile("Heap.txt");

            // 0 position is not used by the heap.
            numbers.push_back(-1);

            if (inputFile.good()) {
                while (inputFile >> num) {
                    numbers.push_back(num);
                }
                inputFile.close();
            }
            else {
                cout << "Couldn't read Heap.txt" << endl;
            }

            myheap.myHeap(numbers);
        }

        void printVector() {
            myheap.printItems();
        }

        void extractMin() {
            cout << "-> Removed " << myheap.at(1) << " from queue" << endl;
            cout << "Moved " << myheap.at(myheap.heapSize()) << " to position 1" << endl;
            myheap.extractRoot();
        }

        void insertItem(int item) {
            cout << "-> Inserted " << item << " to queue" << endl;
            myheap.insertItem(item);
        }
};

int main() {
    // Random integers
    vector<int> itemsToInsert = {89, 21, 93, 8, 19, 24, 32, 5, 51, 4, 27};

    answer myanswer;
    myanswer.readFile();

    // Print initial vector state
    myanswer.printVector();

    for (int i = 0; i < itemsToInsert.size(); i++) {
        // Remove one item from queue
        myanswer.extractMin();

        // and add another one
        myanswer.insertItem(itemsToInsert[i]);
    }

    // Print final vector state
    myanswer.printVector();
}
