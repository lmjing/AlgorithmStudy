//
//  Baekjoon.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 10. 19..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

//func num2805(m: Int, n: Int, array: [Int]) -> Int{
//    let sortedTree = array.sorted()
//    var min = sortedTree[0]; var max = sortedTree[m-1]
//    var mid = 0
//    while( min < max ) {
//        mid = (min + max) / 2
//        let result = sumOfHeightTree(mid, tree: array)
//        if result < n {
//            min = mid + 1
//        }else if result > n {
//            max = mid - 1
//        }else {
//            return mid
//        }
//    }
//    return 0
//}
//
//func sumOfHeightTree(_ height: Int, tree: [Int]) -> Int{
//    var sum = 0
//    for t in tree {
//        sum += t - height > 0 ? t - height : 0
//    }
//    return sum
//}

