//
//  Math.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2018. 8. 20..
//  Copyright © 2018년 이미정. All rights reserved.
//

import Foundation

let input = readLine()!.split(separator: " ").map{ Int($0)! }

func getGcd(_ a : Int, _ b : Int) -> Int {
    return b == 0 ? a : getGcd(b, a % b)
}

let gcd = getGcd(input[0], input[1])
let lcm = input[0] * input[1] / gcd

print(gcd)
print(lcm)
