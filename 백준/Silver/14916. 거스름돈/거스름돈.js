const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

const dp = Array.from({ length: N + 1 }, () => 100_001);
dp[0] = Infinity;
dp[1] = Infinity;

const output = foo(N);
console.log(output === Infinity ? -1 : output);

function foo(n) {
  if (n < 0) {
    return Infinity;
  } else if (n === 2 || n === 5) {
    return 1;
  } else if (dp[n] !== 100_001) {
    return dp[n];
  } else {
    dp[n] = Math.min(1 + foo(n - 2), 1 + foo(n - 5));
    return dp[n];
  }
}