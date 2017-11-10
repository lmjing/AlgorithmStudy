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

func fac(_ n: Int) -> Int {
    if n == 1 || n == 0 {
        return n
    }
    return n * fac(n - 1)
}

if input[0] < input[1] {
    print(0)
}else {
    let diff = input[0] - input[1]
    let result = fac(input[0]) / (fac(input[1]) * fac(diff))
    print(result)
}

//var dp: [[[Int]]] = []
//
//dp.append([[1, 1, 1], [1, 1, 1], [1, 1, 1], [1]])
//dp.append([[2, 3, 2], [3, 4, 3], [3, 3, 2], [1]])
//
//print(dp.count)
//
//func rect(n: Int, x: Int, y: Int) -> Int {
//    return 1
//}
//
//let count = Int(readLine()!)!
//var answer: [Int] = []
//for _ in 0..<count {
//    let input = Int(readLine()!)!
//    var sum = 0
//    for i in 0..<4 {
//        let y = i == 3 ? 1 : 3
//        for j in 0..<y {
//            sum += rect(n: input, x: i, y: j)
//        }
//    }
//    answer.append(sum)
//}
//
