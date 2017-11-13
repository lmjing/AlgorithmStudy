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

Baekjun().num2609()

let input = readLine()!.split(separator: " ").map{ Int($0)! }
var large = input[0] > input[1] ? input[0] : input[1]
var small = input[0] > input[1] ? input[1] : input[0]

func getGcd() -> Int {
    while true {
        let rest = large % small
        if rest == 0 {
            return small
        }
        large = small
        small = rest
    }
}

let gcd = getGcd()
print(gcd)
print(input[0] * input[1] / gcd)

