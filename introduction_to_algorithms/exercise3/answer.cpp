#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

class answer {
    vector< vector<int> > intLists;
    vector<int> mergedVector;

    bool binarySearch(int num, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) {
            return num == mergedVector[mid];
        }
        else {
            if (mergedVector[mid] > num) {
                return binarySearch(num, start, mid - 1);
            }
            else if (mergedVector[mid] < num) {
                return binarySearch(num, mid + 1, end);
            }
        }
    }

    public:
    answer(string filename1, string filename2) {
        vector<string> filenames = {filename1, filename2};

        for (int i=0; i < filenames.size(); i++) {
            ifstream file(filenames[i]);
            int num;

            intLists.push_back({});

            while (file >> num) {
                intLists[i].push_back(num);
            }

            file.close();
        }
    }

    void mergeDescendingVectors() {
        mergedVector.clear();

        vector<int> *vec1 = &intLists[0], *vec2 = &intLists[1];
        vector<int> vecInitSizes = {(int)vec1->size(), (int)vec2->size()};

        int listIdx;
        vector<int> *vec;
        int vecSize;
        while (! vec1->empty() || ! vec2->empty()) {
            if (vec1->empty()) {
                listIdx = 1;
            }
            else if (vec2->empty()) {
                listIdx = 0;
            }
            else {
                listIdx = vec1->back() < vec2->back() ? 0 : 1;
            }
            vec = &intLists[listIdx];
            vecSize = vecInitSizes[listIdx];

            if (vec->size() == vecSize / 2) {
                cout << "Vector " << listIdx + 1 << " dropped below 50% after removeing item: " << vec->back() << " (Idx: " << vec->size() << ")" << endl;
                cout << "Merged vector " << ((float)mergedVector.size() + 1) * 100 / (vecInitSizes[0] + vecInitSizes[1]) << "% full." << endl;
            }

            mergedVector.push_back(vec->back());
            vec->pop_back();
        }
   }

    void checkIfNumberExists() {
        int num;

        cout << "Type the number to check: " << endl;
        cin >> num;
        cout << "Number " << (binarySearch(num, 0, mergedVector.size() - 1) ? "" : "not ") << "found!";
    }

    void printVector() {
        cout << "Vec (size=" << mergedVector.size() << ")" << endl;
        for (int i = 0; i < mergedVector.size(); i++) {
            cout << mergedVector[i] << endl;
        }
    }
};

int main() {
    answer myanswer("Vector1.txt", "Vector2.txt");
    myanswer.mergeDescendingVectors();
    myanswer.checkIfNumberExists();
}
