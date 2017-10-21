
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
    
    //dynamic1 -LongestPassword
    public func longestPassword(_ S : inout String) -> Int {
        let input = S.characters.split(separator: " ").map{ String($0) }
        var max = 0
        
        for str in input {
            let englishRegex = try! NSRegularExpression(pattern: "[a-zA-Z]", options: [])
            let numRegex = try! NSRegularExpression(pattern: "[0-9]", options: [])
            
            let englishCount = englishRegex.numberOfMatches(in: str, options: [], range: NSMakeRange(0, str.utf16.count))
            let numCount = numRegex.numberOfMatches(in: str, options: [], range: NSMakeRange(0, str.utf16.count))
            
            if englishCount % 2 == 0 && numCount % 2 == 1 {
                let length = str.characters.count
                max = max < length ? length : max
            }
        }
        return max
    }
    
    public func minPerimeterRectangle(_ N : Int) -> Int {
        let max = Int(sqrt(Double(N)))
        var min = 2 * ( 1 + N )
        var a = 2
        while a <= max {
            if N % a == 0 {
                let b = N / a
                let perimeter = 2 * ( a + b )
                min = perimeter < min ? perimeter : min
            }
            a += 1
        }
        return min
    }
    
    public func solution1(_ S : inout String) -> Int {
        let inputArray = Array(S.characters)
        var leftCount = 0
        var rightCount = 0
        var leftTurn = true
        
        var divide = 0
        
        for i in 0..<inputArray.count {
            let c = inputArray[i]
            if leftTurn == true {
                if c == "(" {
                    leftCount += 1
                }else {
                    if leftCount > 0 {
                        leftTurn = false
                        rightCount += 1
                        divide = i
                    }
                }
            }else {
                if c == ")" {
                    rightCount += 1
                }else {
                    break
                }
            }
        }
        
        if leftTurn {
            if leftCount == 0 {
                return inputArray.count
            }
            if rightCount == 0 {
                return 0
            }
        }
        
        if leftCount < rightCount {
            let diff = rightCount - leftCount
            return divide + diff
        }else if leftCount > rightCount {
            let diff = leftCount - rightCount
            return divide - diff
        }else {
            return divide
        }
    }
    
    public func solution2(_ A : inout [Int]) -> Bool {
        let originArray = A
        let sortedArray = originArray.sorted()
        var count = 0
        
        for i in 0..<A.count {
            if originArray[i] != sortedArray[i] {
                count += 1
                if count > 2 {
                    return false
                }
            }
        }
        return true
    }
    
    public func solution3(_ S : inout String) -> Int {
        let minute5 = 5 * 60
        
        var max = 0
        var phoneBook: [String: Int] = [:]
        // input 나누어 저장하기. & 저장하며 값 비교하기
        for input in S.components(separatedBy: "\n") {
            let divide = input.components(separatedBy: ",")
            let time = divide[0].components(separatedBy: ":")
            let phone = divide[1]
            guard let hour = Int(time[0]), let minute = Int(time[1]), let second = Int(time[2]) else { return 0 }
            let allSecond = hour * 24 * 60 + minute * 60 + second
            if let beforeSecond = phoneBook[phone] {
                phoneBook[phone] = beforeSecond + allSecond
            }else {
                phoneBook[phone] = allSecond
            }
            
            // 값이 변경되었으니 최대값을 비교 후 갱신
            max = max < phoneBook[phone]! ? phoneBook[phone]! : max
        }
        
        var price = 0
        for (_, time) in phoneBook {
            // max는 제외한다.
            if time != max {
                if time > minute5 {
                    var minute = time / 60
                    // 1초 이상 넘어갔으면 올림 해준다.
                    let rest = time % 60
                    if rest > 0 {
                        minute += 1
                    }
                    price += minute * 150
                }else {
                    price += time * 3
                }
            }
        }
        
        return price
    }
}
