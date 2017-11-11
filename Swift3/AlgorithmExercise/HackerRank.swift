//
//  HackerRank.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 11. 11..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class HackerRank {
    class WarmUp {
        static func ComparetheTriplets() {
            let aPoints = readLine()!.split(separator: " ").map{ Int($0)! }
            let bPoints = readLine()!.split(separator: " ").map{ Int($0)! }
            
            var alice = 0; var bob = 0;
            for i in 0..<aPoints.count {
                
                if aPoints[i] > bPoints[i] {
                    alice += 1
                }else if aPoints[i] < bPoints[i] {
                    bob += 1
                }
            }
            print("\(alice) \(bob)")
        }
        
        static func DiagonalDifference() {
            // read the integer n
            let n = Int(readLine()!)!
            
            // declare 2d array
            var arr: [[Int]] = []
            
            // read array row-by-row
            for _ in 0..<n {
                arr.append(readLine()!.components(separatedBy: " ").map{ Int($0)! })
            }
            
            var sum1 = 0; var sum2 = 0
            for i in 0..<n {
                sum1 += arr[i][i]
                sum2 += arr[i][n - i - 1]
            }
            
            print(abs(sum1 - sum2))
        }
    }
}
