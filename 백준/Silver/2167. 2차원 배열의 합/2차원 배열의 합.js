const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [nums, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = nums.split(" ").map(Number);
const arr = inputs.slice(0, N).map((value) => value.split(" ").map(Number));
const sum = Array.from({ length: N + 1 }, () => new Array(M + 1).fill(0));
for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= M; j++) {
    sum[i][j] =
      sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i - 1][j - 1];
  }
}

const T = +inputs[N];
let input = "";
for (let i = N + 1; i < inputs.length; i++) {
  const [x1, y1, x2, y2] = inputs[i].split(" ").map(Number);
  input += `${
    sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]
  }\n`;
}
console.log(input);