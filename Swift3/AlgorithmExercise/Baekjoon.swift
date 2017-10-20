//
//  Baekjoon.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 10. 19..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class Baekjun {
    func num2309() {
        var sum = 0
        var input:[Int] = []
        for _ in 0..<9 {
            let su = Int(readLine()!)!
            input.append(su)
            sum += su
        }
        
        func getAnswer() -> [Int] {
            for i in 0..<9 {
                let one = input[i]
                for j in ( i + 1 )..<9 {
                    let two = input[j]
                    let sub = sum - one - two
                    if sub == 100 {
                        input.remove(at: j)
                        input.remove(at: i)
                        
                        return input.sorted()
                    }
                }
            }
            return []
        }
        
        print(getAnswer())
    }
}
