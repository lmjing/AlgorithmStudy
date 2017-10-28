//
//  main.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 9. 13..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

//let kakaoTest = KakaoTest()
//kakaoTest.testSolution1()

//let woowaTest = WoowaTest()
//woowaTest.testSolution1()
//woowaTest.testSolution2()
//woowaTest.testSolution3()

//test1 윤년 / 평년 계산
//let input = Int(readLine()!)!
//
//if input % 4 == 0 {
//    if input % 100 == 0 && input % 400 != 0 {
//        print("Not Leap Year")
//    }else {
//        print("Leap Year")
//    }
//}
//test2 16진수 변환
//var input = Int(readLine()!)!
//var result: String = ""
//
//while input >= 16 {
//    var rest = String(input % 16)
//    switch(input % 16) {
//    case 10: rest = "a"
//    case 11: rest = "b"
//    case 12: rest = "c"
//    case 13: rest = "d"
//    case 14: rest = "e"
//    case 15: rest = "f"
//    default: break
//    }
//    input /= 16
//    result = "\(rest)" + result
//}
//print("\(input)" + result)

//1번
//let input = readLine()!
//
//let arr = input.characters.split(separator: " ").map{ Int(String($0))! }
//
//let n = arr[0]
//let d = arr[1]
//var k = arr[2]
//let j = arr[3]
//
////여기부터 작성해 주세요
//var array: [Int] = []
//array.append(1)
//
//if d == 0 {
//    for i in (2...n).reversed() {
//        array.append(i)
//    }
//}else if d == 1 {
//    for i in 2...n {
//        array.append(i)
//    }
//}
//
//var find = k
//var i = find
//while array.count > 1 {
//    let count = array.count
//    if i >= count {
//        i %= count
//    }
//    array.remove(at: i)
//
//    find += j
//    i += find - 1
//}
//
//print(array.first!)

//2번
//let n = Int(readLine()!)!
//var array: [Int]
//for _ in 0..<n {
//    let input = readLine()!.characters.split(separator: " ").map{ Int(String($0))! }
//    let a = input[0]
//    let b = input[1]
//
//    //여기부터 작성해 주세요
//
//
//}

let n = Int(readLine()!)!

var array: [Int] = Array(repeating: 0, count: 1000000000)
var max = 0

for _ in 0..<n {
    let input = readLine()!.characters.split(separator: " ").map{ Int(String($0))! }
    let a = input[0]
    let b = input[1]
    
    //여기부터 작성해 주세요
    //가장 배열을 생성하기 위해 가장 큰 값을 찾는다.
    if max < b {
        max = b
    }
    
    for i in (a * 2 - 1)..<(b * 2 - 1) {
        array[i] += 1
    }
}

var result: [String] = []
var index = (-1, -1, -1)
for i in 0..<(max * 2) {
    if i == max * 2 - 1 {
        //마지막이면
        var start = (index.0 + 1) / 2
        if start == 0 {
            result.append("(-, +)")
            break
        }else if index.0 == -1 {
            start = (i + 1) / 2
        }
        result.append("(\(start), +)")
    }
    if array[i] % 2 == 0 {
        //저장되어있지 않다면
        if index.0 == -1 {
            index.0 = i
            index.2 = array[i]
        }
    }else {
        //시작값이 존재하는 경우
        if index.0 > -1 {
            index.1 = i
            
            switch(index.0) {
            case 0: result.append("(-, \((index.1 + 1) / 2))")
            default:
                let start = (index.0 + 1) / 2
                let end = (index.1 + 1) / 2
                
                if index.2 == 0 {
                    //0인 경우 닫힌 구간이다.
                    result.append("(\(start), \(end))")
                }else {
                    result.append("[\(start), \(end)]")
                }
            }
            index = (-1, -1, -1)
        }
    }
}
print(result)

//3번
//let input = readLine()!
//
//let points = input.characters.split(separator: " ").map{ Int(String($0))! }
//let x1 = points[0]
//let y1 = points[1]
//let x2 = points[2]
//let y2 = points[3]
//
//let x3 = points[4]
//let y3 = points[5]
//let x4 = points[6]
//let y4 = points[7]
//
//let x5 = points[8]
//let y5 = points[9]
//let x6 = points[10]
//let y6 = points[11]

//여기부터 작성해 주세요

//func interSection(mainLB: (Int, Int), mainRT: (Int, Int), LB: (Int, Int), RT: (Int, Int)) -> Int {
//    if LB.0 < mainRT.0 && LB.0 > mainLB.0 {
//        //오른쪽에 위치할 경우
//        if LB.1 < mainRT.1 && LB.1 > mainLB.1 {
//            //아래가 겹칠 경우
//            return (mainRT.0 - LB.0) * (mainRT.1 - LB.1)
//        }else if RT.1 < mainRT.1 && RT.1 > mainLB.1 {
//            // 위가 겹칠 경우
//            return (mainRT.0 - LB.0) * (RT.1 - mainLB.1)
//        }
//    }else if RT.0 < mainRT.0 && RT.0 > mainLB.0 {
//        //왼쪽 위치
//        if LB.1 < mainRT.1 && LB.1 > mainLB.1 {
//            //아래가 겹칠 경우
//            return (RT.0 - mainLB.0) * (mainRT.1 - LB.1)
//        }else if RT.1 < mainRT.1 && RT.1 > mainLB.1 {
//            // 위가 겹칠 경우
//            return (RT.0 - mainLB.0) * (RT.1 - mainLB.1)
//        }
//    }
//    return 0
//}
//var section1 = (x2 - x1) * (y2 - y1)
//func interSection(LB1: (Int, Int), RT1: (Int, Int), LB2: (Int, Int), RT2: (Int, Int)) -> ((Int, Int), (Int, Int)) {
//    let maxLX = max(LB1.0, LB2.0)
//    let maxLY = max(LB1.1, LB2.1)
//    let minRX = min(RT1.0, RT2.0)
//    let minRY = min(RT1.1, RT2.1)
//    return ((maxLX, maxLY),(minRX, minRY))
//}
//
//func getSection(LB: (Int, Int), RT: (Int, Int)) -> Int {
//    return (RT.0 - LB.0) * (RT.1 - LB.1)
//}
//
//let point1LB = (x1, y1)
//let point1RT = (x2, y2)
//let point2LB = (x3, y3)
//let point2RT = (x4, y4)
//let point3LB = (x5, y5)
//let point3RT = (x6, y6)
//
//let inter12 = interSection(LB1: point1LB, RT1: point1RT, LB2: point2LB, RT2: point2RT)
//let section12 = getSection(LB: inter12.0, RT: inter12.1)
//let inter13 = interSection(LB1: point1LB, RT1: point1RT, LB2: point3LB, RT2: point3RT)
//let section13 = getSection(LB: inter13.0, RT: inter13.1)
//let inter23 = interSection(LB1: point2LB, RT1: point2RT, LB2: point3LB, RT2: point3RT)
//let inter123 = interSection(LB1: point1LB, RT1: point1RT, LB2: inter23.0, RT2: inter23.1)
//let section123 = getSection(LB: inter123.0, RT: inter123.1)
//
//print(section1 - section12 - section13 + section123)

//let inter12 = interSection(mainLB: point1LB, mainRT: point1RT, LB: point2LB, RT: point2RT)
//let inter13 = interSection(mainLB: point1LB, mainRT: point1RT, LB: point3LB, RT: point3RT)
//let inter23 = interSection(mainLB: point2LB, mainRT: point2RT, LB: point3LB, RT: point3RT)
//print(section1 - inter12 - inter13 + inter23)
