#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class answer {
    vector<int> numbers;

    int posOfMinInt = 0;
    int posOfMaxInt = 0;

    public:
        void readFile() {
            int current_number;
            ifstream inputFile("input.txt");

            if (inputFile.good()) {
                while (inputFile >> current_number) {
                    numbers.push_back(current_number);
                }

                inputFile.close();
            }
            else {
                cout << "Error in reading file!";
            }
        }

        void writeFile() {
            ofstream outputfile;
            outputfile.open("output.txt");
            for (int i = 0; i < numbers.size(); i++) {
                outputfile << numbers[i] << " "; }
            outputfile.close();
        }

        void findMinAndMax() {
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers[i] < numbers[posOfMinInt]) {
                    posOfMinInt = i;
                }
                else if (numbers[i] > numbers[posOfMaxInt]) {
                    posOfMaxInt = i;
                }
            }
        }

        void printMinAndMax() {
            cout << "Min: " << numbers[posOfMinInt] << "\t(idx: " << posOfMinInt << ")" << endl;
            cout << "Max: " << numbers[posOfMaxInt] << "\t(idx: " << posOfMaxInt << ")" << endl;
        }

        void swapMinWithSecondToLast() {
            int temp = numbers[numbers.size() - 2];

            numbers[numbers.size() - 2] = numbers[posOfMinInt];
            numbers[posOfMinInt] = temp;
        }

        void swapMaxWithLast() {
            int temp = numbers[numbers.size() - 1];

            numbers[numbers.size() - 1] = numbers[posOfMaxInt];
            numbers[posOfMaxInt] = temp;
        }
};

int main() {
    answer myanswer;
    myanswer.readFile();

    myanswer.findMinAndMax();
    myanswer.printMinAndMax();

    myanswer.swapMinWithSecondToLast();
    myanswer.swapMaxWithLast();

    myanswer.writeFile();
}
