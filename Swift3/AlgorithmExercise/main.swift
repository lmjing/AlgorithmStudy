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

Baekjun().num2875()

let input = readLine()!.split(separator: " ").map{ Int($0)! }
let n = input[0]; let m = input[1]; let k = input[2]

var min = n / 2 < m ? n / 2 : m
while n + m - min * 3 < k {
    min -= 1
}
print(min)
