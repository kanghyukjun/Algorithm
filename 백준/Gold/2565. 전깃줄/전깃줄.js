const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const n = +N;
inputs.forEach((input, idx, arr) => (arr[idx] = input.split(" ").map(Number)));
inputs.sort((e1, e2) => e1[0] - e2[0]);

const dp = new Array(n).fill(0);
let max = 0;
for (let idx = inputs.length - 1; idx >= 0; idx--) {
  const [a, b] = inputs[idx];
  let count = 0;
  for (let next = idx + 1; next < inputs.length; next++) {
    const [nA, nB] = inputs[next];
    let small = 0;
    let big = 0;
    if (nA < nB) {
      small = nA;
      big = nB;
    } else {
      small = nB;
      big = nA;
    }
    if (isCross(a, b, nA, nB)) {
      continue;
    }
    count = Math.max(count, dp[next]);
  }
  dp[idx] = count + 1;
  max = Math.max(max, dp[idx]);
}
console.log(n - max);

function isCross(a, b, nA, nB) {
  if (b > nB) return true;
  return false;
}