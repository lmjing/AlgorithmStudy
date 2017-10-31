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
        var test1 = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11"
        test.equal(answer: algorithm.codingTest2_1(&test1), expect: "22", funcName: funcName)
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
