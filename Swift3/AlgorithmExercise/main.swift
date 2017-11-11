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
var wine: [Int] = []
var dp: [Int] = []

for i in 0..<count {
    wine.append(Int(readLine()!)!)
    switch(i) {
    case 0: dp.append(wine[0])
    case 1: dp.append(wine[0] + wine[1])
    case 2: dp.append(max(dp[1], wine[0] + wine[2], wine[1] + wine[2]))
    default:
        var m = max(dp[i-1], dp[i-2] + wine[i])
        m = max(m, dp[i-3] + wine[i-1] + wine[i])
        dp.append(m)
    }
}

print(dp[count-1])
