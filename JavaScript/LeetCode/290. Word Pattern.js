/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function(pattern, s) {
    const splited = s.split(" ")
    
    if (pattern.length !== splited.length) return false
    
    const mapper = {}
    let i = 0
    const set1 = new Set(), set2 = new Set()
    
    while (i < pattern.length) {
        const a = pattern.charAt(i)
        const b = splited[i++]
        
        set1.add(a)
        set2.add(b)
        
        if (set1.size !== set2.size) return false
        if (!mapper[a]) mapper[a] = b
        else if (mapper[a] !== b) return false
    }
    return true
};
