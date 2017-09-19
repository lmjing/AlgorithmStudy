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
        test.equal(answer: kakao.Solution1(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]),
                   expect: ["#####","# # #", "### #", "#  ##", "#####"],
                   funcName: funcName)
        test.equal(answer: kakao.Solution1(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10]),
                   expect: ["######", "### #", "## ##", " #### ", " #####", "### # "],
                   funcName: funcName)
    }
}
