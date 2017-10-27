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
    
    func num1188() {
        let input = readLine()!.characters.split(separator: " ").map{ Int(String($0))! }
        var n = input[0] // 소시지
        var m = input[1] // 평론가
        var slice = 0
        
        // m = 0 이 될 경우 더이상 나누어 주어야 할 사람이 없으므로 종료
        while m > 0 {
            /*
             1. 소시지 > 평론가
             1) 딱 떨어지지 않는 경우 : 소 / 평 만큼 소시지를 통째로 나누어주면 되고 남은 것들을 어떻게 다시 나누어 줄건지 고민하면 됨
             2) 딱 떨어지는 경우 : 통째로 나누어주고 남은 소시지가 없음
             2. 소시지 = 평론가 : 통째로 나누어주고 남은 소시지가 없음
             3. 소시지 < 평론가 : n은 그대로 유지 됨
             */
            n = n % m
            // 1.2) 와 2.의 경우 모두 주고 남은 소시지가 없으므로 종료한다.
            if n == 0 {
                break
            }
            /*
             상태: 소시지 < 평론가
             1) 딱 떨어지는 경우 ex) n = 2, m = 6
             - 평론가 / 소시지 = 사람들에게 동일하게 나누어 주기 위해 하나의 소시지가 잘린 개수 (ex - 하나의 소시지가 3개로 잘린다. )
             - 즉, 소시지 하나가 잘린 횟수 = 개수 - 1 (ex - 자른 결과가 3개가 되기 위해선 2번 잘라야 한다. )
             - 전체 횟수 = 하나가 잘린 횟수 * 소시지 개수
             2) 딱 떨어지지 않는 경우 ex) n = 5, m = 7
             - 모든 사람들에게 제공할 잘려진 소시지의 크기 = Double(평론가 / 소시지)
             - Int(평론가 / 소시지) = 잘린 하나의 소시지에서 큰 비율의 소시지를 받을 수 있는 사람의 수 (ex - 5/7 크기로 잘린 하나의 소시지는 한 사람에게 제공됨 )
             - 소시지 하나가 잘린 횟수 = 큰 비율로 잘린 소시지의 개수 (ex - 5/7 크기를 제공하기 위해선 1번 잘라야 한다. )
             - 전체 횟수 = 하나가 잘린 횟수 * 소시지 개수
             */
            if m % n == 0 {
                slice += (m / n - 1) * n
            }else {
                slice += (m / n) * n
            }
            /*
             1) 딱 떨어지는 경우 ex) n = 2, m = 6
             - 동일한 크기의 소시지를 모든 사람들에게 나누어 주었으므로 소시지를 받아야할 사람은 없다. m = 0
             2) 딱 떨어지지 않는 경우 ex) n = 5, m = 7
             - Double(평론가 / 소시지) 크기를 제공받은 사람들은 Int(평론가 / 소시지)명이며 이를 제외한 나머지 사람들에게 똑같은 크기의 소시지를 제공해야 함
             ( ex - 7명중 5명은 5/7크기의 소시지를 받았으며 남은 2명이 작아진 소시지를 5/7크기 만큼 나누어 가져야 한다. )
             */
            m %= n
            // 2)의 경우 수는 적어졌지만, 균등한 크기의 소시지를 못받았으므로 동일한 크기의 소시지를 제공하기 위해 loop를 돈다.
        }
        print(slice)
    }
    
    func num1003() {
        var save: [Int: (Int, Int)] = [:]
        func fibonacci(_ n: Int) -> (Int, Int) {
            if (n==0) {
                return (1, 0)
            } else if (n == 1) {
                return (0, 1)
            } else {
                return ( save[n - 1]!.0 + save[n - 2]!.0, save[n - 1]!.1 + save[n - 2]!.1 )
            }
        }
        for i in 0...40 {
            save[i] = fibonacci(i)
        }
        
        let count = Int(readLine()!)!
        var result: [String] = []
        for i in 0..<count {
            let input = Int(readLine()!)!
            if let r = save[input] {
                result.append("\(r.0) \(r.1)")
            }
        }
        
        for r in result {
            print(r)
        }
    }
    
    func num1463() {
        func cal(_ n: Int) -> [Int]? {
            var result: [Int] = []
            if n % 3 == 0 {
                result.append(n / 3)
            }
            if n % 2 == 0 {
                result.append(n / 2)
            }
            result.append(n - 1)
            
            if result.contains(1) {
                return nil
            }else {
                return result
            }
        }
        
        func foundLeast(_ input: Int) -> Int{
            if input == 1 {
                return 0
            }else {
                var count = 0
                var resultArray: [Int] = [input]
                while true {
                    count += 1
                    //이전에 저장되어 있던 수들을 새로운 결과로 변환한 후 새로운 배열에 담는다.
                    var newArray:[Int] = []
                    for n in resultArray {
                        if let array = cal(n) {
                            newArray += array
                        }else {
                            //빈 배열이 돌아오면 1이 되었다는 의미이므로 카운트를 리턴한다.
                            return count
                        }
                    }
                    resultArray = newArray
                }
            }
        }
        
        let input = Int(readLine()!)!
        print(foundLeast(input))

    }
    
    func num1000() {
        let input = readLine()!.split(separator: " ").flatMap{ Int($0) }
        print( input[0] + input[1] )
    }
}
