const crypto = require('crypto');

const plaintext = "Death is an old friend";

function sha256Hash(text) {
    return crypto.createHash('sha256').update(text).digest('hex');
}

const sha256Result = sha256Hash(plaintext);

console.log("Plaintext:", plaintext);
console.log("\nSHA-256 Hash:");
console.log(sha256Result);
