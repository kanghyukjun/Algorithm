const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, arr] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
arr = arr
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e2 - e1);

let max = 0;

for (const el of arr) {
  if (max < el) max = el;
  max--;
}

console.log(max + arr.length + 2);