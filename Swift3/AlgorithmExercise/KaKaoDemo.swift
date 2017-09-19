//
//  Test1.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 9. 15..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

func solution1(_ n:Int) -> Int
{
    guard n <= 100000000 && n > 0 else { return -1 }
    
    var answer:Int = 0
    var input = n

    while input > 0 {
        answer += input % 10
        input /= 10
    }
    
    return answer
}

func solution2(_ arr:[Int]) -> Bool {
    let arrCount = arr.count
    guard arrCount <= 100000 else { return false }
    
    let sortArray = arr.sorted()
    for index in 1...arrCount {
        guard sortArray[index-1] == index else { return false }
    }
    
    return true
}

/*
 문제3 : 직사각형을 이루는 하나의 점 찾기
 */

//내가 푼 것
func solution3(_ v: [[Int]]) -> [Int]
{
    var ans = [Int]()
    
    var check = (Set<Int>(), Set<Int>())
    
    for value in v {
        if check.0.contains(value[0]) {
            check.0.remove(value[0])
        }else{
            check.0.insert(value[0])
        }
        if check.1.contains(value[1]) {
            check.1.remove(value[1])
        }else{
            check.1.insert(value[1])
        }
    }
    ans = [check.0.first!, check.1.first!]
    
    return ans
}

/*
 문제 풀이 : XOR 이용
 x1 xor x1 xor x2 = x2이기 때문에
 이를 이용한다.
 */
func solution3_1(_ v: [[Int]]) -> [Int]
{
    var ans = [0,0]
    
    for value in v {
        ans[0] ^= value[0]
        ans[1] ^= value[1]
    }
    
    return ans
}

/*
 문제4 : 가장 큰 정사각형 찾기(못풀어서 해결문제 봄)
 Dynamic Programming ( 중간의 어떤 점 입장 )
 1. 북, 북서, 서의 최대 경계선(최대 정사각형이 될 수 있는 한 변의 길이)을 확인한다
 2. 위에서 확인한 것 중 최소값 + 1(자기 자신) 이 자신의 최댓 값이 된다.
 3. 해당 정보를 저장하는 같은 2차원 배열을 만든다.
 
 전체 해결 : 시간 복잡도 O(MxN) = 전체 사각형의 크기
 만큼 돌면서 북, 북서, 서를 확인해 해당 최솟값 + 자기자신(1)을 더 한다.
 max와 비교한 후 저장한다.
 최종 정답은 max*max이다.
 */
func solution4(_ board:[[Int]]) -> Int
{
    var check:[[Int]] = {
        let row = Array(repeating: 0, count: board[0].count)
        return Array(repeating: row, count: board.count)
    }()
    var max = 0
    
    for row in 0..<board.count {
        for column in 0..<board[row].count {
            let value = board[row][column]
            if value == 1 {
                let top = row > 0 ? check[row - 1][column] : 0
                let left = column > 0 ? check[row][column - 1] : 0
                let digonal = row > 0 && column > 0 ? check [row - 1][column - 1] : 0
                
                check[row][column] = min(top, left, digonal) + 1
                if check[row][column] > max { max = check[row][column]}
            }else {
                check[row][column] = 0;
            }
        }
    }
    
    return max * max
}

/*
 문제5
 */
func solution5(_ land:[[Int]]) -> Int{
    var answer = 0
    
    var dp:[[Int]] = {
        let row = Array(repeating: 0, count: 4)
        var result = Array(repeating: row, count: land.count)
        result[0] = land[0]
        return result
    }()
    
    for row in 1..<land.count {
        for column in 0..<4 {
            var maxValue = 0
            let crrentValue = land[row][column]
            for beforeColumn in 0..<4 {
                if column != beforeColumn {
                    maxValue = max(maxValue, dp[row-1][beforeColumn] + crrentValue)
                }
            }
            dp[row][column] = maxValue
        }
    }
    
    for v in dp[dp.count-1] {
        answer = max(answer, v)
    }
    
    return answer
}

/*
 문제6 : 스티커 뜯기
 많이 뜯어 봤자 좋을게 없다.
 하나를 뜯은 후 최대한 뜯기지 않게 바로 다음 스티커를 뜯는 형식으로
 
 case1 : 0번째를 뜯은 경우 ( 마지막 값 확인 X )
    dp[0] = sticker[0]
 case2 : 0번째 안 뜯은 경우 ( 마지막 값 확인 )
    dp[0] = 0
 
 dp[1] = sticker[1]
 for i in 2..<count 검사한다.
    dp[i] =  max ( i-2 + i , i-1 )
 
 마지막에 case1,2 비교 큰 값
*/
//func solution6(_ sticker:[Int]) -> Int{
//    var ans = 0
//    var dp:[[Int]] = {
//        var row = Array(repeating: 0, count: sticker.count)
//        var result = Array(repeating: row, count: 2)
//        result[0][1] = sticker[1]
//        result[1][0] = sticker[0]; result[1][1] = sticker[1]
//        return result
//    }()
//    
//    for index in 2..<sticker.count {
//        
//        dp[1][index] =
//        if index < sticker.count - 1 {
//            
//        }
//    }
//    
//    return ans
//}

/*
 문제7: 문자열 최소로 완성하기
 
 1. 완성해야하는 글자에서 가장 적게 들어있는 알파벳을 찾는다.
 2. 해당 글자가 들어있는 경우를 찾는다.
 1) 하나라면 필수
 2) 여러개라면 각 케이스를 비교한다.
 */

func solution7(_ strs:[String], _ t:String) -> Int{
    var answer:Int = 0
    
//    let tWords = t.characters.sorted()
//    var leastWord: Character? = nil
//    var min = tWords.count
//    var minCount = 1
//    for index in 1..<tWords.count {
//        if tWords[index-1] != tWords[index] {
//            if min > minCount {
//                min = minCount
//                leastWord = tWords[index-1]
//            }
//            if min == 1 { break }
//            minCount = 0
//        }else {
//            minCount += 1
//        }
//    }
    
    for standard in 0..<strs.count {
        let subStr = t.replacingOccurrences(of: strs[standard], with: "")
        for index in 0..<strs.count {
            let rest = subStr.replacingOccurrences(of: strs[index], with: "")
            
        }
    }
    
    return answer
}
