//
//  KaKao.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 9. 16..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class Kakao {
    
    /*
     MARK: Q1. 비밀지도
     모두 맞음
     */
    func Solution1(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
        var answer: [String] = []
        
        func convertBinary(_ input: Int) -> String {
            var result = ""
            var num = input
            
            //2. 2진수로 변환하고 1일 경우 벽(#), 0일 경우 공백( )으로 변환한다.
            while num > 0 {
                let str = num % 2 == 1 ? "#" : " "
                num /= 2
                result = str + result
            }
            //3. 수로 변환하여 n만큼의 자리수를 못 채우는 경우 앞 부분을 모두 공백으로 채워준다.
            let diff = n - result.characters.count
            
            return String(repeatElement(" ", count: diff)) + result
        }
        
        for index in 0..<n {
            //1. 숫자상태에서 OR 처리해준다.
            let orResult = arr1[index] | arr2[index]
            answer.append(convertBinary(orResult))
        }
        
        return answer
    }
    
    /*
     MARK: Q2. 다트 게임
     시험 채점 때 2개 틀림
     */
    func solution2(_ dartResult:String) -> Int {
        let input = dartResult.characters
        var scoreList:[Int] = [Int]()
        var checkTen = false
        
        for c in input {
            let cursor = scoreList.count - 1
            if let score = Int(String(c)) {
                if score == 0 && checkTen == true {
                    scoreList[cursor] = 10
                }else {
                    if score == 1 {
                        checkTen = true
                    }else {
                        checkTen = false
                    }
                    scoreList.append(score)
                }
            }else {
                let score = scoreList[cursor]
                switch c {
                case "D":
                    scoreList[cursor] = score * score
                case "T":
                    scoreList[cursor] = score * score * score
                case "*":
                    scoreList[cursor] = score * 2
                    if cursor > 0 {
                        scoreList[cursor - 1] *= 2
                    }
                case "#":
                    scoreList[cursor] = -score
                default: continue
                }
            }
        }
        
        var totalScore = 0
        for v in scoreList {
            totalScore += v
        }
        
        return totalScore
    }
}

//3번 교체시기가 언제인지 모르겠음
func solution3(_ cacheSize:Int, _ cities:[String]) -> Int {
    var count = [String:Int]()
    var cache = [String]()
    var answer = 0
    
    for c in cities {
        let city = c.uppercased()
        if cache.contains(city) {
            count[city] = count[city]! + 1
            answer += 1
            cache = cache.sorted(by: { count[$0]! < count[$1]! })
        }else if cacheSize == 0 {
            answer += 5
        }else{
            if cache.count >= cacheSize {
                cache.removeFirst()
            }
            cache.append(city)
            count[city] = count[city] != nil ? count[city]!+1 : 0
            answer += 5
        }
    }
    
    return answer
}

// 시간 계산 못하겠음
//func solution4(_ n:Int, _ t:Int, _ m:Int, _ timetable:[String]) -> String {
//    var dp = [[String]]()
//    
//    let sortedTable = timetable.sorted()
//    var index = 0
//    
//    let format = DateFormatter()
//    var calendar = Calendar.current
//    
//    format.dateFormat = "HH:mm"
//    let defaultTime = format.date(from: "09:00")
//    var busTime = defaultTime
//    
//    for i in 0..<n {
//        var visit = [String]()
//        for j in 0..<m {
//            let visitTime = format.date(from: sortedTable[index])
//            
//            let diff = calendar.dateComponents([.minute], from: busTime!, to: visitTime!)
//            print(sortedTable[index], diff.minute!)
//
//            if diff.minute! <= 0 {
//                visit.append(sortedTable[index])
//                index += 1
//            }
//        }
//        dp.append(visit)
//        busTime?.addTimeInterval(TimeInterval(t * 60))
//    }
//    
//    var lastRow = dp.count - 1
//    while lastRow > 0 && dp[lastRow].count >= m {
//        lastRow -= 1
//    }
//    let enableLastTime = defaultTime?.addingTimeInterval(TimeInterval(t * 60 * lastRow))
//    let RowTime = format.string(from: enableLastTime!)
//
//    return RowTime
//}

func solution4(_ n:Int, _ t:Int, _ m:Int, _ timetable:[String]) -> String {
    var dp = [[String]]()
    
    var sortedTable = timetable.sorted()
    var index = 0
    
    let defaultTime = "09:00"
    var busTime = defaultTime
    
    for i in 0..<n {
        var visit = [String]()
        for j in 0..<m {
            var stringTime = sortedTable[index].characters
//            if diff.minute! <= 0 {
//                visit.append(sortedTable[index])
//                index += 1
//            }
        }
        dp.append(visit)
//        busTime?.addTimeInterval(TimeInterval(t * 60))
    }
//    
//    var lastRow = dp.count - 1
//    while lastRow > 0 && dp[lastRow].count >= m {
//        lastRow -= 1
//    }
//    let enableLastTime = defaultTime?.addingTimeInterval(TimeInterval(t * 60 * lastRow))
//    let RowTime = format.string(from: enableLastTime!)
//    
    return ""
}

func solution5(_ str1:String, _ str2:String) -> Int {
    
    //1. 문자 2자씩 끊기
    var test = str1.characters.reduce(" ", { String($0) + String($1) })
    var str1Array = [String]()
    
    print(test)
    
    return 0
}

func solution6(_ m:Int, _ n:Int, _ board:[String]) -> Int {
    var answer = 0
    
    var strArray: [[Character?]] = {
        var result = [[Character?]]()
        for i in 0..<m {
            var row = [Character]()
            for c in board[i].characters {
                row.append(c)
            }
            result.append(row)
        }
        
        return result
    }()
    
    for i in 1..<m {
        for j in 1..<n {
            let value = strArray[i][j]
            if strArray[i-1][j-1] == value && strArray[i-1][j] == value && strArray[i][j-1] == value {
                answer += 1
                strArray[i-1][j-1] = nil
                strArray[i-1][j] = nil
                strArray[i][j-1] = nil
                strArray[i][j] = nil
                
                for k in 0..<i {
                    for w in 0..<j {
                        strArray[k+1][w] = strArray[k][w]
                    }
                }
            }
        }
    }
    
    print(strArray)
    
    return 0
}
