/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortEvenOdd = function(nums) {
    const odd = nums.filter((_, $) => $%2===1).sort((a, b) => b-a)
    const even = nums.filter((_, $) => $%2===0).sort((a, b) => a-b)
    let answer = []
    let oc = 0, ec = 0
    for(let i=0; i<nums.length; i++) {
        answer.push((i%2===0) ? even[ec++] : odd[oc++])
    }
    return answer
};
