let prime = (() => {
    let prime = [];
    for(let i=2; i<3000; i++) {
        if(prime.find(e => i%e === 0) == undefined){
            prime.push(i);
        } else if(prime.length === 0) {
            prime.push(i);
        }
    }
    return prime;
})(); // 1 미포함
//
// function solution(n) {
//     let sum = n === 1 ? 1 : 1 + n;
//     let i = 0;
//     let max = n;
//     while(primeFactor[i] < max) {
//         let p = primeFactor[i];
//         if(n % p === 0) {
//             max = n / p;
//             console.log(`약수 ${p}와 ${max}를 더해서 ${sum} => ${sum + p + max}`);
//             sum += p + max;
//         }
//         ++i;
//     }
//     return sum;
// }

function solution(n) {
    // 1과 자기자신은 무조건 들어간다. (n이 1일 때 예외케이스)
    let factors = new Set();
    factors.add(1);
    let factor = 1;
    while (n > factor) {
        // n을 소인수로 나누어 딱 떨어지는 수 찾음
        factors.add(n);
        let f = prime.find(e => n % e === 0); // undefined로 나오는 경우는 1뿐
        factor *= f;
        factors.add(f);
        factors.add(factor);
        console.log(`factor에 ${n} 과 ${f} 과 ${factor} add`);
        n = n / f;
    }
    if (n < factor)
    factors.add(n);
    console.log(`factor에 ${n} add`);
    let sum = 0;
    factors.forEach(e => sum += e);
    return sum;
}

console.log(solution(1));
console.log(solution(12));
console.log(solution(128));
console.log(solution(252));
console.log(solution(252));


/*
 2016 윤년 날짜 요일 구하기
 */
function solution(a, b) {
    let day = new Date(2016, a-1, b);
    // let day = new Date(`2016-${a}-${b}`);

    var weekDay = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
    return weekDay[day.getDay()];
    // return day.toString().slice(0, 3).toUpperCase();
}
//success
function solution(a, b) {
    let dayStr = ['SUN','MON','TUE','WED','THU','FRI','SAT'];
    let dayCnt = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let date = b;
    for (let i=0; i<a-1; i++) {
        date += dayCnt[i];
    }
    let day = (4 + date) % 7;
    return dayStr[day];
}
let date3 = new Date(95,11,17);
console.log(date3.toString());

// 같은 숫자는 싫어
function solution(arr)
{
    return arr.reduce((acc, e) => {
        if (acc[acc.length-1] !== e) acc.push(e);
        return acc;
    }, []);
    // return arr.filter((e, i) => arr[i+1] !== e);
}

// 문자열 내 p와 y의 개수
function solution(s){
    /*
    let cntResult = s.split("").reduce((cnt, e) => {
        let str = e.toUpperCase();
        if (str === 'Y') cnt[0]++;
        else if (str === 'P') cnt[1]++;
        return cnt;
    }, [0, 0]);
    return cntResult[0] === cntResult[1];
    */
    let result = s.split("").reduce((cnt, e) => {
        cnt[e.toUpperCase()]++;
        return cnt;
    }, {P: 0, Y: 0});
    return result['P'] === result['Y'];
}