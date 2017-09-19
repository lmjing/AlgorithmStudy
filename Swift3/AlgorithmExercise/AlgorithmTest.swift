//
//  AlgorithmTest.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 9. 19..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class Test {
    func equal(answer: String,  expect: String, funcName: String) {
        if answer != expect {
            printError(answer: answer, expect: expect, funcName: funcName)
        }
    }
    
    func equal(answer: Int,  expect: Int, funcName: String) {
        if answer != expect {
            printError(answer: answer, expect: expect, funcName: funcName)
        }
    }
    
    func equal(answer: [String],  expect: [String], funcName: String) {
        if answer != expect {
            printError(answer: answer, expect: expect, funcName: funcName)
        }
    }
    
    func printError(answer: Any,  expect: Any, funcName: String) {
        print("-------------------")
        print("\(funcName)틀림. ")
        print("expect : \(expect)")
        print("answer : \(answer)" )
        print("-------------------")
    }
}
