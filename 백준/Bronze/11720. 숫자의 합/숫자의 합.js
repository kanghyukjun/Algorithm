const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

console.log(
  inputs
    .split("")
    .map(Number)
    .reduce((acc, val) => acc + val)
);