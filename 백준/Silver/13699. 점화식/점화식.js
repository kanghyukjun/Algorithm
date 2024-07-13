const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

const dp = [1n];

for (let i = 1; i <= N; i++) {
  let sum = 0n;
  for (let j = 0; j < i; j++) {
    sum += dp[j] * dp[i - j - 1];
  }
  dp[i] = sum;
}

console.log(dp[N].toString());