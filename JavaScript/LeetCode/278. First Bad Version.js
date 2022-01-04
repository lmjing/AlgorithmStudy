var solution = function(isBadVersion) {
    return function(n) {
        let min = n
        let left = 0, right = n-1

        while(left <= right) {
            const i = left + Math.floor((right - left) / 2)

            if (isBadVersion(i+1)) {
                min = Math.min(min, i)
                right = i-1
            } else left = i+1
        }
        return min + 1
    };
};