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
    
    func testSolution1() {
        let funcName = "woowa Solution1"
        var a = [3, 4, 4, 6, 1, 4, 4]
//        test.equal(answer: algorithm.solution(5, &a), expect: [3, 2, 2, 4, 2], funcName: funcName)
        var a2 = [4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 1, 6]
        test.equal(answer: algorithm.solution(5, &a2), expect: [10, 10, 10, 10, 10], funcName: funcName)
    }
}
