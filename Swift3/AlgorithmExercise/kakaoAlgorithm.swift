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
    func solution1(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
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
    
    /*
     MARK: Q3. 캐시
     못품
     
     LRU 알고리즘 : 각 실행시간을 알아 둔 후, 제일 오래된 값과 교체한다. ( 기존에 있었다면, 나중 시간으로 변경됨 )
     다시푸니깐 얼마 안걸림 ( 원리 이해 X )
     */
    func solution3(_ cacheSize:Int, _ cities:[String]) -> Int {
        if cacheSize == 0 {
            return cities.count * 5
        }
        
        var answer = 0
        var cache = [String]()
        
        for c in cities {
            let city = c.uppercased()
            if let index = cache.index(of: city) {
                //cache에 있다면 없앤 후 다시 넣어준다.
                cache.remove(at: index)
                cache.append(city)
                answer += 1
            }else {
                if cache.count >= cacheSize {
                    cache.removeFirst()
                }
                cache.append(city)
                answer += 5
            }
        }
        
        return answer
    }
    
    /*
     MARK: Q4. 셔틀버스
     못품
     
     input
     n : 셔틀 운행 횟수, t: 셔틀 운행 간격, m : 한 셔틀에 탈 수 있는 최대 크루 수, timetable : 크루가 대기열에 도착하는 시각을 모은 배열
     
     조건
     0 ＜ n ≦ 10, 0 ＜ t ≦ 60, 0 ＜ m ≦ 45
     */
    func solution4(_ n:Int, _ t:Int, _ m:Int, _ timetable:[String]) -> String {
        var resultTable: [[Int]] = {
            let row = [Int]()
            return Array(repeating: row, count: n)
        }()
        var inputTimeTable = timetable.sorted()
        var startTime = 900
        var busTime = startTime
        
        func parseStringTime(hour: Int, minute: Int) -> String {
            let strHour = hour < 10 ? "0" + String(hour) : String(hour)
            let strMinute = minute < 10 ? "0" + String(minute) : String(minute)
            
            return strHour + ":" + strMinute
        }
        
        for bus in 0..<n {
            for _ in 0..<m {
                guard var strTime = inputTimeTable.first else { break }
                strTime.remove(at: strTime.index(strTime.startIndex, offsetBy: 2))
                if let intTime = Int(strTime) {
                    //작거나 같을 경우에만 저장
                    if intTime <= busTime {
                        resultTable[bus].append(intTime)
                        inputTimeTable.removeFirst()
                    }else {
                        break
                    }
                }
            }
            busTime += t
        }
        
        for row in (0..<resultTable.count).reversed() {
            let rowCount = resultTable[row].count
            let time = startTime + t * row

            if rowCount >= m {
                //꽉 차 자리가 없는 경우
                if let last = resultTable[row].last {
                    //마지막 사람이 이전+1 ~ 해당 시간에 해당하는 사람일 경우
                    //맨 처음일 경우 am00:01부터
                    if last <= time && (row == 0 ? last > 0 : last > time - 10 ) {
                        //TODO : 마지막 사람 - 1 분 구현한 후 리턴
                        let resultTime = last % 100 > 0 ? last - 1 : last - 100 + 59
                        let hour = resultTime / 100, minute = resultTime % 100
                        return parseStringTime(hour: hour, minute: minute)
                    }else {
                        //윗 행으로 올라가 확인
                        continue
                    }
                }
            }else {
                //자리가 있는 경우(비었거나)
                //TODO : 시작시간 + t * row 시간 계산하여 리턴
                let add = t * row
                let hour = startTime / 100 + add / 60
                let minute = startTime % 100 + add % 60
                return parseStringTime(hour: hour, minute: minute)
            }
        }
        
        return ""
    }
    
    func solution5(_ str1:String, _ str2:String) -> Int {
        //1. 문자 2자씩 끊기
        func divSumWord(str: String) -> [String] {
            let characterSet = CharacterSet(charactersIn: "abcdefghijklmnopqrstuvwxyz")
            let originWords = Array(str.lowercased().characters)
            var words = [String]()
            for i in 1..<originWords.count {
                let before = String(originWords[i-1]), current = String(originWords[i])
                if characterSet.contains(before.unicodeScalars.first!) && characterSet.contains(current.unicodeScalars.first!) {
                    words.append(before + current)
                }
            }
            return words
        }
        
        let str1Words = divSumWord(str: str1), str2Words = divSumWord(str: str2)
        let temp = str1Words
        let and = temp.filter({ str2Words.contains($0)})
        let or = str2Words + (str1Words.filter({ !and.contains($0) }))
        
        let answer:Double = or.count == 0 ? 1.0 : Double(and.count) / Double(or.count)
        
        return Int(answer * 65536)
    }
    
    func solution6(_ m:Int, _ n:Int, _ board:[String]) -> Int {
        var answer = 0
        var dp:[[Character?]] = [Array(board[0].characters)]
        
        for i in 0..<m-1 {
            let currentWords = Array(board[i].characters)
            let nextWords = Array(board[i+1].characters)
            dp.append(nextWords)
            for j in 0..<n-1 {
                let word = currentWords[j]
                
                guard word == currentWords[j+1] else { continue }
                guard word == nextWords[j] else { continue }
                guard word == nextWords[j+1] else { continue }
                //모두 동일
                answer += 1
                dp[i][j] = nil; dp[i][j+1] = nil
                dp[i+1][j] = nil; dp[i+1][j+1] = nil
            }
        }
        
        return answer
    }
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
