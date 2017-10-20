////
////  main.swift
////  AlgorithmExercise
////
////  Created by 이미정 on 2017. 9. 13..
////  Copyright © 2017년 이미정. All rights reserved.
////
//
//import Foundation
//
////let kakaoTest = KakaoTest()
////kakaoTest.testSolution1()
////kakaoTest.testSolution2()
////kakaoTest.testSolution3()
////kakaoTest.testSolution4()
////kakaoTest.testSolution5()
////kakaoTest.testSolution6()
//
////let woowaTest = WoowaTest()
////woowaTest.testSolution1()
////
//import Foundation
//
//let line1 = readLine()
//let line2 = readLine()
//
//func sumOfHeightTree(_ height: Int, tree: [Int]) -> Int{
//    var sum = 0
//    for t in tree {
//        sum += t - height > 0 ? t - height : 0
//    }
//    return sum
//}
//
//if let line1 = line1, let line2 = line2 {
//    let line1Characters = line1.characters.split(separator: " ")
//    let line2Characters = line2.characters.split(separator: " ")
//
//    let m = Int(String(line1Characters[0]))!
//    let n = Int(String(line1Characters[1]))!
//    let numbers = line2Characters.map { Int(String($0))! }
//
//    let sortedTree = numbers.sorted()
//    var low = sortedTree[0] - 1; var high = sortedTree[1];
//    var mid = 0
//    while low < high {
//        mid = ( low + high ) / 2
//        let sum = sumOfHeightTree(mid, tree: sortedTree)
//        if sum <= n {
//            high = mid
//        }else {
//            low = mid + 1
//        }
//    }
//    print(mid - 1)
//}
//
//
////import Foundation
////var sol = 0
////
////var input = readLine()!.characters.split(separator: " ").map{ Int(String($0))! }
////var N = input[0]
////var M = input[1]
////var trees = readLine()!.characters.split(separator: " ").map{ Int(String($0))! }
////func sol(_ n :Int,_ N:Int)->Bool{
////    var sum = 0
////    for index in 0..<N{
////        if trees[index]-n >= 0{
////            sum += trees[index]-n
////        }
////
////    }
////    return sum<M
////}
////var low = 0
////var high = 1000000001
////while low < high{
////    var mid = (low+high)/2
////    if sol(mid,N){
////        high = mid
////    }
////    else{
////        low = mid+1
////    }
////}
////print(low-1)
//
//

import Foundation

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
