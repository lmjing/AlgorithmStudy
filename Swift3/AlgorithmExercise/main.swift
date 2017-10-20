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

//let n = Int(readLine()!)!

func num1562(n: Int) -> Decimal{
    if n < 10 {
        return 0
    }else if n == 10{
        return 1
    }else {
        let rest = n - 10
        let available = pow(2, rest / 2)
        if rest % 2 == 0 {
            return available * 11 * 9
        }else {
            return available * 2 * 9
        }
    }
}

var sum:Decimal = 0
for i in 1...40 {
    sum += num1562(n: i)
}
print(sum)

//if n < 10 {
//    print(0)
//}else if n == 10{
//    print(1)
//}else {
//    let rest = n - 10
//    let available = pow(2, rest / 2)
//    if rest % 2 == 0 {
//        print(available * 11)
//    }else {
//        print(available * 2)
//    }
//}

