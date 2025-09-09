const crypto = require('crypto');

const plaintext = "Death is an old friend";

function sha512Hash(text) {
    return crypto.createHash('sha512').update(text).digest('hex');
}

const sha512Result = sha512Hash(plaintext);

console.log("Plaintext:", plaintext);
console.log("\nSHA-512 Hash:");
console.log(sha512Result);