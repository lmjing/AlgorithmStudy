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
    
    func testSolution2() {
        let funcName = "woowa Solution2"
        var param = [1, 3, 5, 3, 4]
        var param2 = [1, 5, 3, 3, 7]
        test.equal(answer: algorithm.solution2(&param), expect: false, funcName: funcName)
        test.equal(answer: algorithm.solution2(&param2), expect: true, funcName: funcName)
    }
    
    func testSolution3() {
        let funcName = "woowa Solution3"
        var param = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090"
        test.equal(answer: algorithm.solution3(&param), expect: 900, funcName: funcName)
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
    
    func testCodingTest2_1() {
        let funcName = "codingTest2_1"
//        test.equal(answer: algorithm.minPerimeterRectangle(30), expect: 22, funcName: funcName)
//        test.equal(answer: algorithm.minPerimeterRectangle(1), expect: 4, funcName: funcName)
//        print(algorithm.minPerimeterRectangle(40))
    }
    
    func testCodingTest2_2() {
        let funcName = "codingTest2_1"
        //        test.equal(answer: algorithm.minPerimeterRectangle(30), expect: 22, funcName: funcName)
        //        test.equal(answer: algorithm.minPerimeterRectangle(1), expect: 4, funcName: funcName)
        //        print(algorithm.minPerimeterRectangle(40))
    }
    
    func testCodingTest2_3() {
        let funcName = "codingTest2_1"
        //        test.equal(answer: algorithm.minPerimeterRectangle(30), expect: 22, funcName: funcName)
        //        test.equal(answer: algorithm.minPerimeterRectangle(1), expect: 4, funcName: funcName)
        //        print(algorithm.minPerimeterRectangle(40))
    }
    
    func testCodingTest2_4() {
        let funcName = "codingTest2_1"
        //        test.equal(answer: algorithm.minPerimeterRectangle(30), expect: 22, funcName: funcName)
        //        test.equal(answer: algorithm.minPerimeterRectangle(1), expect: 4, funcName: funcName)
        //        print(algorithm.minPerimeterRectangle(40))
    }
}
