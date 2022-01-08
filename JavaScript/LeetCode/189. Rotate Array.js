/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 /*
 Runtime: 108 ms, faster than 81.75% of JavaScript online submissions for Rotate Array.
 Memory Usage: 48.8 MB, less than 48.89% of JavaScript online submissions for Rotate Array.
*/
var rotate = function(nums, k) {
    const x = k % nums.length  
    nums.unshift(...nums.splice(-x, x))
    
    return nums
};
