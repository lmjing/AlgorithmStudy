/**
 * @param {number} size
 */
var Bitset = function(size) {
    this.value = new Array(size).fill(0)
};

/** 
 * @param {number} idx
 * @return {void}
 */
Bitset.prototype.fix = function(idx) {
    if(this.value[idx] === 0) this.value[idx] = 1
};

/** 
 * @param {number} idx
 * @return {void}
 */
Bitset.prototype.unfix = function(idx) {
    if(this.value[idx] === 1) this.value[idx] = 0
};

/**
 * @return {void}
 */
Bitset.prototype.flip = function() {
    this.value = this.value.map(_ => _ === 0 ? 1 : 0)
};

/**
 * @return {boolean}
 */
Bitset.prototype.all = function() {
    return this.value.every(_ => _===1)
};

/**
 * @return {boolean}
 */
Bitset.prototype.one = function() {
    return this.value.includes(1)
};

/**
 * @return {number}
 */
Bitset.prototype.count = function() {
    return this.value.filter(_ => _===1).length
};

/**
 * @return {string}
 */
Bitset.prototype.toString = function() {
    return this.value.join("")
};

/** 
 * Your Bitset object will be instantiated and called as such:
 * var obj = new Bitset(size)
 * obj.fix(idx)
 * obj.unfix(idx)
 * obj.flip()
 * var param_4 = obj.all()
 * var param_5 = obj.one()
 * var param_6 = obj.count()
 * var param_7 = obj.toString()
 */
