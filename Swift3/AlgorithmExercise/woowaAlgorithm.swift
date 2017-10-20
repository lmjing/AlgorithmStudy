//
//  woowaAlgorithm.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 10. 18..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class WoowaAlgorithm {
    func solution(_ N : Int, _ A : inout [Int]) -> [Int] {
        var count: [Int:Int] = [:]
        var max = 0
        var all = 0
        for i in A {
            if i == N + 1 {
                all = max
                count.removeAll()
            }else {
                if let before = count[i-1] {
                    count[i-1] = before + 1
                }else {
                    count[i-1] = 1
                }
                if max < count[i-1]! + all {
                    max = count[i-1]! + all
                }
            }
        }
        
        var answer:[Int] = []
        for i in 0..<N {
            var su = all
            if let count =  count[i] {
                su = count + all
            }
            answer.append(su)
        }
        
        return answer
    }
    
    public func solution2(_ A : Int, _ B : Int, _ K : Int) -> Int {
        var count = 0
        for i in A...B {
            if i % K == 0 {
                count += 1
            }
        }
        return count
    }
}
