function solution(s, n) {
    return s.split('').map(e => {
        if (e === ' ') return e;
        let ascii = e.charCodeAt();
        let upper = (ascii <= 90);
        ascii += n;
        if (!upper && ascii > 122) ascii = ascii - 122 + 96;
        else if (upper && ascii > 90) ascii = ascii - 90 + 64;

        return String.fromCharCode(ascii);
    }).join('');
}

function solution(s, n) {
    return s.replace(/[a-z]/gi, e => {
        let ascii = e.charCodeAt();
        let upper = (ascii <= 90);
        ascii += n;
        if (!upper && ascii > 122) ascii = ascii - 122 + 96;
        else if (upper && ascii > 90) ascii = ascii - 90 + 64;

        return String.fromCharCode(ascii);
    });
}