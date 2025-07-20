#include <iostream>
using namespace std;

void countZero(int arr[], int n) {
    int low = 0, high = n - 1;
    int firstZero = -1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == 0) {
            if (mid == 0 || arr[mid - 1] == 1) {
                firstZero = mid;
                break;
            } else {
                high = mid - 1;
            }
        } else {
            low = mid + 1;
        }
    }

    if (firstZero != -1) {
        cout << "Number of zeros: " << n - firstZero << endl;
    } else {
        cout << "No zeros found or invalid input" << endl;
    }
}

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;
    int arr[n];

    cout << "Enter " << n << " elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    countZero(arr, n);
    return 0;
}
