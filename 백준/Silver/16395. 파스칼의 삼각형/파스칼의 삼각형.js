const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

const arr = Array.from({ length: N }, () => new Array(N).fill(0));
arr.forEach((_, index, arr) => {
  arr[index][0] = 1;
  arr[index][index] = 1;
});

for (let i = 1; i < N; i++) {
  for (let j = 1; j < N; j++) {
    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
  }
}

console.log(arr[N - 1][M - 1]);