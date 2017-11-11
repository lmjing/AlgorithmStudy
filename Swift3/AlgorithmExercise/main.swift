////
////  main.swift
////  AlgorithmExercise
////
////  Created by 이미정 on 2017. 9. 13..
////  Copyright © 2017년 이미정. All rights reserved.
////

import Foundation

//let kakaoTest = KakaoTest()
//kakaoTest.testSolution1()

//let woowaTest = WoowaTest()
//woowaTest.testSolution1()
//woowaTest.testSolution2()
//woowaTest.testSolution3()
Baekjun().num2156()

let count = Int(readLine()!)!

struct Check {
    var flag = true
    var count = 0
    var sum = 0
    var su = 0
    
    init(su: Int, flag: Bool, sum: Int, count: Int) {
        self.su = su
        self.flag = flag
        self.sum += sum + (flag ? su : 0)
        self.count = flag ? count + 1 : 0
    }
}
var queue: [Check] = []

let first = Int(readLine()!)!
queue.insert(Check(su: first, flag: true, sum: 0, count: 0), at: 0)
queue.insert(Check(su: first, flag: false, sum: 0, count: 0), at: 0)

for _ in 1..<count - 1 {
    let input = Int(readLine()!)!
    
    while queue.last?.su != input {
        let before = queue.popLast()!
        if before.flag == false {
            queue.insert(Check(su: input, flag: true, sum: before.sum, count: before.count), at: 0)
        }else if before.count == 2 {
            queue.insert(Check(su: input, flag: false, sum: before.sum, count: before.count), at: 0)
        }else {
            queue.insert(Check(su: input, flag: true, sum: before.sum, count: before.count), at: 0)
            queue.insert(Check(su: input, flag: false, sum: before.sum, count: before.count), at: 0)
        }
    }
    
}
// 마지막
var max = 0
let last = Int(readLine()!)!
for c in queue {
    var sum = c.sum
    if c.count < 2 {
        // 들어갈 수 있는 상황에 바로 들어간다
        sum += last
    }
    max = max < sum ? sum : max
}
print(max)

