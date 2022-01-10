/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 /*
 Runtime: 96 ms, faster than 93.13% of JavaScript online submissions for Move Zeroes.
Memory Usage: 43.6 MB, less than 47.35% of JavaScript online submissions for Move Zeroes.
*/
var moveZeroes = function(nums) {
    nums.sort((a, b) => {
        if (a === 0) return 1;
        else if (b === 0) return -1;
        return 0;
    }, [])
    
    return nums
};
