const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);
console.log(N + M);
console.log(N - M);
console.log(N * M);
console.log(Math.floor(N / M));
console.log(N % M);