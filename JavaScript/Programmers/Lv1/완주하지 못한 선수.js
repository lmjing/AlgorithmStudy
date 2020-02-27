console.log(solution(["a", "a", "b", "b", "c"], ["a", "b", "b", "c"]));

// 이전 버전
function solution(participant, completion) {
    let map = new Map();

    // 완주자 셋팅
    for (let i=0; i<completion.length; i++) {
        let player = completion[i];
        map.set(player, map.has(player) ? map.get(player) + 1 : 0);
    }

    // 참가자 순회하며 완주자 명단에 있는지 확인
    for (let i=0; i<participant.length; i++) {
        let player = participant[i];
        if (map.has(player)) {
            let cnt = map.get(player);
            if (cnt > 0) {
                map.set(player, cnt - 1);
            } else {
                map.delete(player);
            }
        } else {
            return player;
        }
    }
    return '';
}

// es6 버전
function isComplete(player, map) {
    let cnt = map.get(player) || 0;
    switch (cnt) {
        case 0: return false;
        case 1: map.delete(player); break;
        default: map.set(player, --cnt);
    }
    return true;
}

function solution(participant, completion) {
    let map = completion
        .reduce((acc, cur, idx, src) => {
            acc.set(cur, acc.get(cur) + 1 || 1);
            return acc;
        }, new Map()); // 완주자 셋팅

    return participant.find(player => !isComplete(player, map));
}

// 더 좋은 정답
function solution(participant, completion) {
    let dic = completion.reduce((obj, cur) => (obj[cur] = (obj[cur]+1 || 1), obj) , {}); // 완주자 셋팅

    return participant.find(player => {
        if (dic[player]) {
           dic[player] = dic[player] - 1;
        } else return true;
    })
}