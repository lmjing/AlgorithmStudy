//
//  kakaoTest.swift
//  AlgorithmExercise
//
//  Created by 이미정 on 2017. 9. 19..
//  Copyright © 2017년 이미정. All rights reserved.
//

import Foundation

class KakaoTest {
    let test = Test()
    let kakao = Kakao()
    
    func testSolution1() {
        let funcName = "kakao Solution1"
        test.equal(answer: kakao.solution1(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]),
                   expect: ["#####","# # #", "### #", "#  ##", "#####"],
                   funcName: funcName)
        test.equal(answer: kakao.solution1(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10]),
                   expect: ["######", "###  #", "##  ##", " #### ", " #####", "### # "],
                   funcName: funcName)
    }
    
    func testSolution2() {
        let funcName = "kakao Solution2"
        test.equal(answer: kakao.solution2("1S2D*3T"),
                   expect: 37,
                   funcName: funcName)
        test.equal(answer: kakao.solution2("1D2S#10S"),
                   expect: 9,
                   funcName: funcName)
        
        test.equal(answer: kakao.solution2("1D2S0T"),
                   expect: 3,
                   funcName: funcName)
        
        test.equal(answer: kakao.solution2("1S*2T*3S"),
                   expect: 23,
                   funcName: funcName)
        
        test.equal(answer: kakao.solution2("1D#2S*3S"),
                   expect: 5,
                   funcName: funcName)
        
        test.equal(answer: kakao.solution2("1T2D3D#"),
                   expect: -4,
                   funcName: funcName)
        
        test.equal(answer: kakao.solution2("1D2S3T*"),
                   expect: 59,
                   funcName: funcName)
    }
    
    func testSolution3() {
        let funcName = "kakao Solution3"
        test.equal(answer: kakao.solution3(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]), expect: 50, funcName: funcName)
        test.equal(answer: kakao.solution3(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]), expect: 21, funcName: funcName)
        test.equal(answer: kakao.solution3(2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]), expect: 60, funcName: funcName)
        test.equal(answer: kakao.solution3(5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]), expect: 52, funcName: funcName)
        test.equal(answer: kakao.solution3(2, ["Jeju", "Pangyo", "NewYork", "newyork"]), expect: 16, funcName: funcName)
        test.equal(answer: kakao.solution3(0, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]), expect: 25, funcName: funcName)
    }
    
    func testSolution4() {
        let funcName = "kakao Solution4"
        test.equal(answer: kakao.solution4(1, 1, 5, ["08:00", "08:01", "08:02", "08:03"]),
                   expect: "09:00", funcName: funcName)
        test.equal(answer: kakao.solution4(2, 10, 2, ["09:10", "09:09", "08:00"]),
                   expect: "09:09", funcName: funcName)
        test.equal(answer: kakao.solution4(2, 1, 2, ["09:00", "09:00", "09:00", "09:00"]),
                   expect: "08:59", funcName: funcName)
        test.equal(answer: kakao.solution4(1, 1, 5, ["00:01", "00:01", "00:01", "00:01", "00:01"]),
                   expect: "00:00", funcName: funcName)
        test.equal(answer: kakao.solution4(1, 1, 1, ["23:59"]),
                   expect: "09:00", funcName: funcName)
        test.equal(answer: kakao.solution4(10, 60, 45, ["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]),
                   expect: "18:00", funcName: funcName)
    }
    
    func testSolution5() {
        let funcName = "kakao Solution5"
        test.equal(answer: kakao.solution5("FRANCE", "french"), expect:
            16384, funcName: funcName)
        test.equal(answer: kakao.solution5("handshake", "shake hands"), expect:
            65536, funcName: funcName)
        test.equal(answer: kakao.solution5("aa1+aa2", "AAAA12"), expect:
            43690, funcName: funcName)
        test.equal(answer: kakao.solution5("E=M*C^2", "e=m*c^2"), expect:
            65536, funcName: funcName)
    }
}
