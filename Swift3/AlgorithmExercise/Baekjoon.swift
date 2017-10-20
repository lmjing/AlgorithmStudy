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
        
        for s in getAnswer() {
            print(s)
        }
    }
    
//    func num1562() -> Decimal{
//        func gettt(n: Int) {
//            if n < 10 {
//                return 0
//            }else if n == 10{
//                return 1
//            }else {
//                let rest = n - 10
//                let available = pow(2, rest / 2)
//                if rest % 2 == 0 {
//                    return available * 11 * 9
//                }else {
//                    return available * 2 * 9
//                }
//            }
//        }
//        
//        var sum:Decimal = 0
//        for i in 1...40 {
//            sum += gettt(n: i)
//        }
//        return sum
//    }
    
    func num6378() {
        var array: [String] = []
        while true {
            guard let input = readLine() else { break }
            if input == "0" {
                break
            }else {
                array.append(input)
            }
        }
        
        for input in array {
            var strArray = Array(input)
            while true {
                var sum = 0
                for su in strArray {
                    sum += Int(su.description)!
                }
                
                if sum >= 10 {
                    strArray = Array(String(sum))
                }else {
                    print(sum)
                    break
                }
            }
        }
    }
}
