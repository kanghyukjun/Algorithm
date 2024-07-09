const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [nums, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = nums.split(" ").map(Number);
const arr = inputs.split(" ").map(Number);

let preSum = 0;
for (let i = 0; i < M; i++) {
  preSum += arr[i];
}

let max = preSum;
for (let i = M; i < N; i++) {
  preSum -= arr[i - M];
  preSum += arr[i];
  max = Math.max(max, preSum);
}

console.log(max);