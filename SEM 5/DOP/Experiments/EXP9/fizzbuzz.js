console.log("FizzBuzz Docker Container Starting...\n");

for (let i = 1; i <= 100; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
        console.log(i + " ==> FizzBuzz (divisible by 3 and 5)");
    }
    else if (i % 3 === 0) {
        console.log(i + " ==> Fizz (divisible by 3)");
    }
    else if (i % 5 === 0) {
        console.log(i + " ==> Buzz (divisible by 5)");
    }
    else {
        console.log(i + " ==> Regular number");
    }
}

console.log("\nFizzBuzz completed!");