/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
/**
 * result
 * Runtime: 106 ms, faster than 12.49% of JavaScript online submissions for Binary Search.
 * Memory Usage: 42 MB, less than 90.01% of JavaScript online submissions for Binary Search.
 */
var search1 = function(nums, target) {
    const bs = (si, ei) => {
        if (ei < si) return -1;

        const i = si + Math.floor((ei - si) / 2);
        const cur = nums[i];

        if (cur === target) return i;
        return (cur < target) ? bs(i+1, ei) : bs(si, i-1);
    }

    return bs(0, nums.length - 1);
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
/**
 * result
 * Runtime: 63 ms, faster than 99.28% of JavaScript online submissions for Binary Search.
 * Memory Usage: 42.4 MB, less than 56.64% of JavaScript online submissions for Binary Search.
 */
var search2 = function(nums, target) {
    let left = 0, right = nums.length - 1;

    while(left <= right) {
        const pivot = left + Math.floor((right - left) / 2);
        if (nums[pivot] === target) return pivot;
        if (nums[pivot] < target) left = pivot + 1;
        else right = pivot - 1;
    }

    return -1;
};