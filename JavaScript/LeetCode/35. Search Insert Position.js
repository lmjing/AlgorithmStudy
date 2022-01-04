/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
/*
Runtime: 73 ms, faster than 56.31% of JavaScript online submissions for Search Insert Position.
Memory Usage: 39.2 MB, less than 92.84% of JavaScript online submissions for Search Insert Position.
 */
var searchInsert = function(nums, target) {
    const latest = nums.length-1
    let left = 0, right = latest

    if(nums[latest] < target) return latest+1
    else if(nums[0] > target) return 0

    let answer = -1

    while(left <= right) {
        const i = left + Math.floor((right - left) / 2)

        if(nums[i] < target) {
            answer = Math.max(answer, i)
            left = i+1
        } else right = i-1
    }
    return answer+1
};