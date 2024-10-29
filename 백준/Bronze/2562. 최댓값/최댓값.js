const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n")
  .map(Number);

const { val, idx } = inputs
  .map((val, idx) => ({ val, idx: idx + 1 }))
  .sort((e1, e2) => e2.val - e1.val)
  .shift();

console.log(`${val}\n${idx}`);