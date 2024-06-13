const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const K = +fs.readFileSync(filePath, "utf-8").trim().split("\n");

const arr = [1, 0];
for (let i = 0; i < K; i++) {
  const sum = arr[0] + arr[1];
  arr[0] = arr[1];
  arr[1] = sum;
}

console.log(arr.join(" "));