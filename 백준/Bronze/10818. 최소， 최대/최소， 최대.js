const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let min = Infinity;
let max = -Infinity;
inputs
  .split(" ")
  .map(Number)
  .forEach((x) => {
    min = Math.min(min, x);
    max = Math.max(max, x);
  });

console.log(min, max);