/**
 * @param {number[]} nums
 * @return {number[]}
 */
/*
Runtime: 151 ms, faster than 30.29% of JavaScript online submissions for Squares of a Sorted Array.
Memory Usage: 45.4 MB, less than 95.34% of JavaScript online submissions for Squares of a Sorted Array.
*/
 var sortedSquares = function(nums) {
    const pows = nums.map(num => Math.pow(num, 2)).sort((_, $) => _-$)
    return pows
};

/*
Runtime: 211 ms, faster than 10.97% of JavaScript online submissions for Squares of a Sorted Array.
Memory Usage: 45.7 MB, less than 81.98% of JavaScript online submissions for Squares of a Sorted Array.
*/
var sortedSquares = function(nums) {
    let answer = []
    let l = 0, r = nums.length - 1
    while(l <= r) {
        if (Math.abs(nums[l]) >= Math.abs(nums[r])) answer.unshift(Math.pow(nums[l++], 2))
        else answer.unshift(Math.pow(nums[r--], 2))
    }
    
    return answer
};