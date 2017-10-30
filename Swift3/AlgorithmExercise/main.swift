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

let input = readLine()!

let arr = input.characters.split(separator: " ").map{ Int(String($0))! }

let m = arr[0]
var n = arr[1]

var array: [Int] = []

for i in 1...m {
    array.append(i)
}

var find = n
var i = find - 1
var result = "<"
while array.count > 1 {
    let count = array.count
    if i >= count {
        i %= count
    }
    result += "\(array[i]), "
    array.remove(at: i)
    
    i += find - 1
}
result += "\(array.first!)>"
print(result)
