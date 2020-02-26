console.log(solution('aabbaccc'));

function solution(s) {
    var answer = s.length;

    for(let i=1; i<=s.length/2; i++) {
        var zipStrLength = zipStr(s, i);
        if (answer > zipStrLength) {
            answer = zipStrLength;
        }
    }

    return answer;
}

function zipStr(s, n) {
    var resultStr = '';
    var before = s.slice(0, n);
    var cnt = 1;
    for (let i=n; i<s.length; i+=n) {
        var cur = s.slice(i, i+n);

        if (cur === before) {
            ++cnt;
        } else {
            resultStr = concatZipStr(resultStr, cnt, before);
            cnt = 1;
        }
        before = cur;
    }
    resultStr = concatZipStr(resultStr, cnt, before);
    return resultStr.length;
}

function concatZipStr(str, cnt, before) {
    if(cnt === 1) {
        return str + before;
    } else {
        return str + cnt.toString() + before;
    }
}}