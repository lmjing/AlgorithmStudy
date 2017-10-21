//
//  woowaTest.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 10. 18..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class WoowaTest {
    let test = Test()
    let algorithm = WoowaAlgorithm()
    
//    func testSolution1() {
//        let funcName = "woowa Solution1"
//        var a = [3, 4, 4, 6, 1, 4, 4]
////        test.equal(answer: algorithm.solution(5, &a), expect: [3, 2, 2, 4, 2], funcName: funcName)
//        var a2 = [4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 1, 6]
//        test.equal(answer: algorithm.solution(5, &a2), expect: [10, 10, 10, 10, 10], funcName: funcName)
//    }
    
    func testSolution1() {
        let funcName = "woowa Solution1"
        var temp = "(())"
        var temp2 = "(())))("
        var temp3 = "))"
        var temp4 = ")))(((())"
        var temp5 = "(("
        test.equal(answer: algorithm.solution1(&temp), expect: 2, funcName: funcName)
        test.equal(answer: algorithm.solution1(&temp2), expect: 4, funcName: funcName)
        test.equal(answer: algorithm.solution1(&temp3), expect: 2, funcName: funcName)
        test.equal(answer: algorithm.solution1(&temp4), expect: 5, funcName: funcName)
        test.equal(answer: algorithm.solution1(&temp5), expect: 0, funcName: funcName)
    }
    
    func testLongestPassword() {
        let funcName = "LongestPassword"
        var s = "test 5 a0A pass007 ?xy1"
        test.equal(answer: algorithm.longestPassword(&s), expect: 7, funcName: funcName)
    }
    
    func testMinPerimeterRectangle() {
        let funcName = "MinPerimeterRectangle"
        test.equal(answer: algorithm.minPerimeterRectangle(30), expect: 22, funcName: funcName)
        test.equal(answer: algorithm.minPerimeterRectangle(1), expect: 4, funcName: funcName)
        print(algorithm.minPerimeterRectangle(40))
    }
}
