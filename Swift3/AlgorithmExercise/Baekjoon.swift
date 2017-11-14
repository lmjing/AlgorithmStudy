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
    
    func num1652() {
        /*
         문제 이해를 제대로 못함...!
         중간에 짐이 있고 양 옆으로 공간이 있는 경우 한 줄에 공간은 여러개가 됨.
         */
        let count = Int(readLine()!)!
        var room: [[Bool]] = []
        var availabe: (Int, Int) = (0, 0)
        for _ in 0..<count {
            let input = readLine()!.characters.map{ $0 == "." ? true : false }
            room.append(input)
            //가로 검사
            var status = false
            for i in 0..<count - 1 {
                //둘다 빈 공간이라면
                if input[i] && input[i + 1] {
                    if !status {
                        availabe.0 += 1
                    }
                    status = true
                }else {
                    //둘 중에 하나라도 빈 공간이라면
                    status = false
                }
            }
        }
        
        //세로 검사
        for j in 0..<count {
            var status = false
            for i in 0..<count - 1 {
                if room[i][j] && room[i + 1][j] {
                    if !status {
                        availabe.1 += 1
                    }
                    status = true
                }else {
                    status = false
                }
            }
        }
        
        print("\(availabe.0) \(availabe.1)")
    }
    
    func num2839() {
        /*
         첫 시도: 무식하게 무조건 5로 나누고 남은게 3으로 나뉜다면 으로 접근하였는데
         16을 예로 들면 16 % 5 == 1이고, 16자체가 3으로 나뉘지 않기 때문에 -1이 리턴되지만,
         사실 5 * 2 + 3 * 2 로 해결 할 수 있다.
         
         test case : 33 = 7 / 50 = 10 / 12, 18 = 4 / 3 = 1 / 2,1,0 = -1
         */
        let input = Int(readLine()!)!
        
        var su = input
        var five = 0, three = 0, count = 9999999
        while su > 0 {
            five += 1
            su -= 5
            
            if su % 3 == 0, su > 0 {
                three = su / 3
                if count > three + five {
                    count = three + five
                }
            }
        }
        
        if five > 0, three > 0 {
            print(input % 5 == 0 ? input / 5 : count)
        }else {
            print(input % 3 == 0 && input > 0 ? input / 3 : -1)
        }
    }
    
    func num11866() {
        let input = readLine()!
        
        let arr = input.characters.split(separator: " ").map{ Int(String($0))! }
        
        let m = arr[0]
        var n = arr[1]
        
        var array: [Int] = []
        
        for i in 1...m {
            array.append(i)
        }
        
        var find = n
        var i = find - 1
        var result = "<"
        while array.count > 1 {
            let count = array.count
            if i >= count {
                i %= count
            }
            result += "\(array[i]), "
            array.remove(at: i)
            
            i += find - 1
        }
        result += "\(array.first!)>"
        print(result)
    }
    
    func num2965() {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        let diff1 = input[1] - input[0]
        let diff2 = input[2] - input[1]
        let max = diff1 < diff2 ? diff2 : diff1
        print(max - 1)
    }
    
    func num1149() {
        // 자기 위에 있는 애 빼고 나머지를 각각 더해서 더 적은 애를 보존한다.
        let count = Int(readLine()!)!
        var rgb = Array(repeating: Array(repeating: 0, count: 3), count: count)
        var minResult = 1000 * count
        for i in 0..<count {
            let input = readLine()!.split(separator: " ").map{ Int($0)! }
            rgb[i] = input
            guard i > 0 else { continue }
            //2째줄 부터
            for j in 0...2 {
                //0,1,2중 자신과 같은 색은 제외한다.
                var index = [0, 1, 2]
                index.remove(at: j)
                let su1 = rgb[i - 1][index[0]]
                let su2 = rgb[i - 1][index[1]]
                
                let min = su1 < su2 ? su1 : su2
                rgb[i][j] += min
                
                //마지막이라면
                guard i == count - 1 else { continue }
                minResult = minResult > rgb[i][j] ? rgb[i][j] : minResult
            }
        }
        print(minResult)
    }
    
    func num1181() {
        let count = Int(readLine()!)!
        var set = Set<String>()
        for _ in 0..<count {
            let input = readLine()!
            set.insert(input)
        }
        let sorted = set.sorted { (one, two) -> Bool in
            if one.count == two.count {
                return one < two
            }else {
                return one.count < two.count
            }
        }
        for str in sorted {
            print(str)
        }
        
        // 첫 시도: dic에 count별로 저장해 두고 다시 일일이 sorted하는 방법 -> 시간초과
//        let count = Int(readLine()!)!
//        var dic: [Int:Set<String>] = [:]
//        for _ in 0..<count {
//            let input = readLine()!
//            if dic[input.count] == nil {
//                dic[input.count] = Set<String>()
//            }
//            dic[input.count]!.insert(input)
//        }
//        let sortedDic = dic.sorted{ $0.0 < $1.0 }
//        for (_, set) in sortedDic {
//            for str in set.sorted() {
//                print(str)
//            }
//        }
    }
    
    func num10866() {
        var deque: [Int] = []
        var result: [Int] = []
        let count = Int(readLine()!)!
        for _ in 0..<count {
            let input = readLine()!.split(separator: " ")
            switch(input[0]) {
            case "push_front":
                if let num = Int(input[1]) {
                    deque.insert(num, at: 0)
                }
                break
            case "push_back":
                if let num = Int(input[1]) {
                    deque.append(num)
                }
                break
            case "pop_front":
                result.append(deque.count > 0 ? deque.removeFirst() : -1)
                break
            case "pop_back":
                if let num = deque.popLast() {
                    result.append(num)
                }else {
                    result.append(-1)
                }
                break
            case "size":
                result.append(deque.count)
                break
            case "empty":
                result.append(deque.isEmpty ? 1 : 0)
                break
            case "front":
                result.append(deque.first != nil ? deque.first! : -1)
                break
            case "back":
                result.append(deque.last != nil ? deque.last! : -1)
                break
            default: break
            }
        }
        for i in result {
            print(i)
        }
    }
    
    func num11050() {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        
        func choose(n: Int, r: Int) -> Int {
            if n == r || r == 0 {
                return 1
            }
            return choose(n: n-1, r: r-1) + choose(n: n-1, r: r)
        }
        
        print(choose(n: input[0], r: input[1]))
    }
    
    // 시간초과
//    func num2156() {
//        let count = Int(readLine()!)!
//
//        struct Check {
//            var flag = true
//            var count = 0
//            var sum = 0
//            var su = 0
//
//            init(su: Int, flag: Bool, sum: Int, count: Int) {
//                self.su = su
//                self.flag = flag
//                self.sum += sum + (flag ? su : 0)
//                self.count = flag ? count + 1 : 0
//            }
//        }
//        var queue: [Check] = []
//
//        let first = Int(readLine()!)!
//        queue.insert(Check(su: first, flag: true, sum: 0, count: 0), at: 0)
//        queue.insert(Check(su: first, flag: false, sum: 0, count: 0), at: 0)
//
//        for _ in 1..<count - 1 {
//            let input = Int(readLine()!)!
//
//            while queue.last?.su != input {
//                let before = queue.popLast()!
//                if before.flag == false {
//                    queue.insert(Check(su: input, flag: true, sum: before.sum, count: before.count), at: 0)
//                }else if before.count == 2 {
//                    queue.insert(Check(su: input, flag: false, sum: before.sum, count: before.count), at: 0)
//                }else {
//                    queue.insert(Check(su: input, flag: true, sum: before.sum, count: before.count), at: 0)
//                    queue.insert(Check(su: input, flag: false, sum: before.sum, count: before.count), at: 0)
//                }
//            }
//
//        }
//        // 마지막
//        var max = 0
//        let last = Int(readLine()!)!
//        for c in queue {
//            var sum = c.sum
//            if c.count < 2 {
//                // 들어갈 수 있는 상황에 바로 들어간다
//                sum += last
//            }
//            max = max < sum ? sum : max
//        }
//        print(max)
//    }
    
    func num2156() {
        let count = Int(readLine()!)!
        var wine: [Int] = []
        var dp: [Int] = []
        
        for i in 0..<count {
            wine.append(Int(readLine()!)!)
            switch(i) {
            case 0: dp.append(wine[0])
            case 1: dp.append(wine[0] + wine[1])
            case 2: dp.append(max(dp[1], wine[0] + wine[2], wine[1] + wine[2]))
            default:
                var m = max(dp[i-1], dp[i-2] + wine[i])
                m = max(m, dp[i-3] + wine[i-1] + wine[i])
                dp.append(m)
            }
        }
        
        print(dp[count-1])
    }
    
    // 2156과 매우 유사
    // NOTE: 실패
    func num2579() {
        let count = Int(readLine()!)!
        var step: [Int] = []
        var dp: [Int] = []
        for _ in 0..<count {
            step.append(Int(readLine()!)!)
        }
        
        for i in (0..<count).reversed() {
            switch(i) {
            case count - 1: dp.append(step[i])
            case count - 2: dp.append(step[i] + dp[0])
            case count - 3: dp.append(max(dp[1], step[count - 1] + step[i]))
            default:
                var m = max(dp[count - i - 2], dp[count - i - 3] + step[i], dp[count - i - 4] + step[i] + step[i + 1])
                dp.append(m)
            }
        }
        
        print(dp.last!)
    }
    
    func num1699() {
        /* 첫 시도 : 큰 수 부터 뺐다.
         -> 실패 : 52 = 49 + 1 + 1 + 1로 나오지만
             성공 : 52 = 36 + 16
         */
//        func cal(_ n: Int) -> (Int, Int) {
//            let s = Int(sqrt(Double(n)))
//
//            return (s, n - (s * s))
//        }
//
//        var input = Int(readLine()!)!
//        var count = 0
//
//        while input > 0 {
//            let result = cal(input)
//            count += 1
//            input = result.1
//        }
//        print(count)
        
        // 두번 째: 실패 안됨 이유 불분명
//        let input = Int(readLine()!)!
//        let count = Int(sqrt(Double(input)))
//        var min = input
//        for i in 1...count {
//            var num = input
//            var count = 0
//            var half = i
//
//            while num > 0 {
//                if num >= half * half {
//                    num -= half * half
//                    count += 1
//                }else {
//                    half -= 1
//                }
//            }
//
//            min = min > count ? count : min
//        }
//        print(min)
        
        //세번째: 해답보고 따라한 거 ( 이전의 최소값을 활용해 구하는 방법 )
        /* 원리
         1부터 자기 자신까지 각 수에 해당하는 최소값을 찾아 저장 시킴
         검색범위는 1 ~ 구하고자 하는 수 >= 수 - j*j까지 이며
         dp[i] 가 비었을 경우(0)는 구해졌던 값이 없으므로 무조건 넣어주고
         dp[i - j*j] + 1보다 작을 때 넣어주는데 ( 최소값이 바뀐 것이므로 )
         dp[i - j*j] + 1인 이유는 i - j*j는 구하고자 하는 값에서 제곱값 하나를 뺀 값(나머지)이므로
         나머지의 최소dp와 (j*j = 제곱값 횟수1번)을 더해주는 것이다.
         */
        let input = Int(readLine()!)!
        var dp: [Int] = Array(repeatElement(0, count: 100001))
        
        for i in 1...input {
            var j = 1
            while j*j <= i {
                if dp[i] == 0 || dp[i] > dp[i - j*j] + 1 {
                    dp[i] = dp[i - j*j] + 1
                    print(i, i - j*j, dp[i])
                }
                j += 1
            }
        }
        print(dp[input])
    }
    
    func num1789() {
        /* 원리
         i = 1부터 시작해서 1씩 증가시켜 차례대로 빼간 나머지를 비교한다.
         => 더한 값의 개수가 최대가 되기 위해서는 최대한 작은 수 끼리 더해야하기 때문
         나머지 값이 만약 i보다 작다면 그 값은 이미 사용된 값이므로 멈춘다.
         */
        var s = Int(readLine()!)!
        var i = 1
        var count = 1
        while s - i > i {
            s -= i
            count += 1
            i += 1
        }
        
        print(count)
    }
    
    //NOTE: 실패
    func num1058() {
        /*
         testcase:
         8
         NNNYNNYN
         NNNNYYNN
         NNNYNNNN
         YNYNNNNN
         NYNNNYNN
         NYNNYNNN
         YNNNNNNY
         NNNNNNYN
         */
        let count = Int(readLine()!)!
        var dic:[Int:[Int]] = [:]
        for i in 0..<count {
            dic[i] = []
            var input = readLine()!.characters
            var j = 0
            while !input.isEmpty {
                if let c = input.popFirst(), c == "Y" {
                    dic[i]!.append(j)
                }
                j += 1
            }
        }
        
        var max = 0
        for i in 0..<count {
            var friends = dic[i]!.count
            for f in dic[i]! {
                friends += dic[f]!.filter{ !dic[i]!.contains($0) }.count - 1
            }
            max = friends > max ? friends : max
        }
        print(max)
    }
    
    func num1260() {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        let n = input[0]; let m = input[1]; let start = input[2];
        var dp:[[Int]] = Array(repeatElement(Array(repeatElement(0, count: n + 1)), count: n + 1))
        
        for _ in 0..<m {
            let mInput = readLine()!.split(separator: " ").map{ Int($0)! }
            //대칭되는 점 잊지 말기!
            dp[mInput[0]][mInput[1]] = 1
            dp[mInput[1]][mInput[0]] = 1
        }
        
        //dfs
        /*
         재귀 이용
         방문 노드, 기록 노드를 구별지어 놓고
         기록 노드에서 연결되어있고 방문하지 않은 경우 재귀호출한다.
         */
        var dfsResult = ""
        var visited:[Bool] = Array(repeatElement(false, count: n + 1))
        func dfs(v: Int) {
            visited[v] = true
            dfsResult += "\(v) "
            for i in 1..<dp[v].count {
                if dp[v][i] == 1 && visited[i] == false {
                    dfs(v: i)
                }
            }
        }
        
        dfs(v: start)
        
        //bfs
        var queue: [Int] = [start]
        visited = Array(repeatElement(false, count: n + 1))
        visited[start] = true
        var bfsResult = "\(start) "
        
        while !queue.isEmpty {
            let v = queue.first!; queue.removeFirst()
            for i in 1..<dp[v].count {
                if dp[v][i] == 1 && visited[i] == false {
                    queue.append(i)
                    visited[i] = true
                    bfsResult += "\(i) "
                }
            }
        }
        
        print(dfsResult)
        print(bfsResult)
    }
    
    func num2875() {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        let n = input[0]; let m = input[1]; let k = input[2]
        
        var min = n / 2 < m ? n / 2 : m
        while n + m - min * 3 < k {
            min -= 1
        }
        print(min)
    }
    
//    func num6064() {
//        /*
//         원리
//         1. 큰 수를 기준으로 가상의 정답 z년을 구한다.
//         2. z년일 경우 y가 어떤 답이 나오는지 확인 한 후 비교한다.
//         3. 정답일 경우 z를 리턴한다.
//         4. 2번의 답을 따로 담아둔 후 2번에서 이미 나왔던 경우이면 -1을 리턴한다. -> 계속 반복되어 정답이 없단 의미 이므로.
//         */
//        func getLcm(n: Int, m: Int) -> Int {
//            var large = n > m ? n : m
//            var small = n < m ? n : m
//            var gcd = 0
//            while true {
//                let rest = large % small
//                if rest == 0 {
//                    gcd = small; break
//                }
//                large = small
//                small = rest
//            }
//            return n * (m / gcd)
//        }
//
//        let count = Int(readLine()!)!
//        var resultArray: [Int] = []
//
//        for _ in 0..<count {
//            var input = readLine()!.split(separator: " ").map{ Int($0)! }
//            guard input[2] <= input[0] && input[3] <= input[1] else {
//                resultArray.append(-1); break
//            }
//
//            // m = x, n = y의 경우 나눈 값이 0이 나오므로 추후 쉬운 비교를 위해 0으로 바꾼다.
//            input[2] = input[2] == input[0] ? 0 : input[2]
//            input[3] = input[3] == input[1] ? 0 : input[3]
//
//            // 큰 값을 기준으로 잡아야 실행 횟수가 줄어든다. ( 해당 value가 아니라 index를 담아둔다. )
//            var standard = input[0]; var standardRest = input[2];
//            var find = input[1]; var findRest = input[3];
//            if input[0] < input[1] {
//                standard = input[1]; standardRest = input[3];
//                find = input[0]; findRest = input[2];
//            }
//
//            let lcm = getLcm(n: standard, m: find)
//            var checked: [Int] = []
//            var i = 0
//            while true {
//                let num = standard * i + standardRest
//                guard num > 0 else { i += 1; continue }
//                guard num <= lcm else { resultArray.append(-1); break }
//                let rest = num % find
//                print(rest)
//                if rest == findRest {
//                    resultArray.append(num); break
//                }else if checked.contains(rest) {
//                    resultArray.append(-1); break
//                }
//                checked.append(rest)
//                i += 1
//            }
//        }
//
//        for r in resultArray {
//            print(r)
//        }
//    }
    func num6064() {
        let count = Int(readLine()!)!
        var result: [Int] = []
        for _ in 0..<count {
            let input = readLine()!.split(separator: " ").map{ Int($0)! }
            
            // 계산을 위해 m,n중 큰 값과 그에 따라 찾고자 하는 값을 구별 짓는다.
            var large = input[0]; var lRest = input[2]
            var small = input[1]; var sRest = input[3]
            if large < small {
                large = input[1]; lRest = input[3]
                small = input[0]; sRest = input[2]
            }
            
            // 찾고자 하는 일이 m, n보다 같거나 작지 않다면 -1을 저장하고 그만한다.
            guard lRest <= large && sRest <= small else { result.append(-1); continue }
            
            let diff = large - small
            
            guard diff > 0 else {
                // 예외 처리 : 0으로 나눌 수 없으므로 이 경우는 따로 처리해준다.
                result.append(lRest == sRest ? lRest : -1); continue
            }
            
            // 쉬운 계산을 위해 찾고자하는 일이 m, n과 같을 경우 0으로 변경한다. => 나머지 값이 0
            lRest = large == lRest ? 0 : lRest
            sRest = small == sRest ? 0 : sRest
            
            var top = sRest - lRest
            if sRest < lRest {
                top += small
            }
            let i = Double(top / diff)
            
            // i가 소수점을 가진다면 -1이 정답.
            if Int(i * 10) % 10 != 0 {
                result.append(-1)
            }else {
                // 정수로 딱 나눠 떨어진다면 '큰 수*횟수 + 큰수 나머지'가 정답
                result.append(large * Int(i) + lRest)
            }
        }
        
        for r in result {
            print(r)
        }
    }
    
    func num2609() {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        var large = input[0] > input[1] ? input[0] : input[1]
        var small = input[0] > input[1] ? input[1] : input[0]
        
        func getGcd() -> Int {
            while true {
                let rest = large % small
                if rest == 0 {
                    return small
                }
                large = small
                small = rest
            }
        }
        
        let gcd = getGcd()
        let lcm = input[0] * input[1] / gcd
        
        print(gcd)
        print(lcm)
    }
}
