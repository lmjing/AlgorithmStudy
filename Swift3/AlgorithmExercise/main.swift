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
Baekjun().num11050()

let input = readLine()!.split(separator: " ").map{ Int($0)! }

func choose(n: Int, r: Int) -> Int {
    if n == r || r == 0 {
        return 1
    }
    return choose(n: n-1, r: r) + choose(n: n-1, r: r-1)
}

print(choose(n: input[0], r: input[1]))
