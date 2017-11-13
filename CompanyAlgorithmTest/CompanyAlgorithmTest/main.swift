//
//  main.swift
//  CompanyAlgorithmTest
//
//  Created by 이미정 on 2017. 11. 12..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

func findNumber(arr: [Int], k: Int) -> String {
    return arr.contains(k) ? "YES" : "NO"
}

func oddNumbers(l: Int, r: Int) -> [Int] {
    var result: [Int] = []
    for i in l...r {
        if i % 2 == 1 {
            result.append(i)
        }
    }
    return result
}
