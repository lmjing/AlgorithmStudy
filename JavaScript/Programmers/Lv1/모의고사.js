function solution(answers) {
    const tl = [3, 1, 2, 4, 5];
    let sum = [{name: 1, score: 0},
        {name: 2, score: 0},
        {name: 3, score: 0}];
    let t = 1;
    for(let i=0; i<answers.length; i++) {
        let answer = answers[i];

        let one = (i%5) + 1;
        if (one === answer) sum[0].score++;

        let two = i%2 ? t++ : 2;
        if (t == 2) ++t;
        else if (t == 6) t = 1;
        if (two === answer) sum[1].score++;

        let th = parseInt(parseInt(i%10) / 2);
        let three = tl[th];
        if (three === answer) sum[2].score++;
    }
    return sum.sort((a, b) => a.score < b.score)
        .filter(e => e.score >= sum[0].score)
        .map(e => e.name);
}

function solution2(answers) {
    let t = 1;
    let tl = [3, 1, 2, 4, 5];
    let score = answers.reduce((sum, ans, i) => {
        let one = (i % 5) + 1;

        let two = (i % 2) ? t++ : 2;
        if (t === 2) ++t;
        else if (t === 6) t = 1;

        let th = parseInt(parseInt(i%10) / 2);
        let three = tl[th];

        return [scoring(one, ans, sum[0]),
            scoring(two, ans, sum[1]),
            scoring(three, ans, sum[2])];
    }, [0, 0, 0]);

    let max = Math.max(...score);
    return [1, 2, 3].filter(e => score[e-1] === max);
}