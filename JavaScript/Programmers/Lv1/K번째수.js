console.log(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]));
// console.log(solution([9, 8, 7, 6, 5, 4, 3, 2, 1], [[1, 9, 5]]));
//
// let inputArray = [];
// for (let i=100; i>0; i--) {
//     inputArray.push(i);
// }
// let inputCommans = [];
// for (let i=1; i<=50; i++) {
//     inputCommans.push([1, 100-i, 1]);
// }
// console.log(inputArray);
// console.log(inputCommans);
// console.log(solution(inputArray, inputCommans));

function solution(array, commands) {
    // 내부 sort 활용
    return commands.map(_ => array.slice(_[0]-1, _[1]).sort((_, $) => _-$)[_[2]-1]);

    // quick sort
    // return  commands.map(command => {
    //     let copied = array.slice(command[0]-1, command[1]);
    //     quickSort(copied, 0, copied.length-1);
    //     return copied[command[2]-1];
    // });

    // merge sort
    // return commands.map(command => mergeSort(array, command[0]-1, command[1]-1)[command[2]-1]);
}

function swap(array, i, j) {
    let temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function quickSort(array, s, e) {
    if (s >= e) return;

    let pivot = array[s];
    let low = s + 1;
    let high = e;

    while (low <= high) {
        while (low <= e && array[low] < pivot) {
            ++low;
        }
        while (high > s && array[high] > pivot) {
            --high;
        }
        if (low < high) {
            swap(array, low, high);
            low++; high--;
        }
    }
    swap(array, s, high);
    quickSort(array, s, high - 1);
    quickSort(array, high + 1, e);
}

function mergeSort(array, s, e) {
    let result = [];
    if (e <= s) {
        result.push(array[s]);
    } else {
        let half = s + parseInt((e - s) / 2);
        let left = mergeSort(array, s, half);
        let right = mergeSort(array,half + 1, e);

        let l = 0;
        let r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result.push(left[l++]);
            } else {
                result.push(right[r++]);
            }
        }
        while (l < left.length) {
            result.push(left[l++]);
        }
        while (r < right.length) {
            result.push(right[r++]);
        }
    }
    return result;
}