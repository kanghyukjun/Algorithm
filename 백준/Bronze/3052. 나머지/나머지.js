const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const inputs = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n")
  .map(Number);

const set = new Set();
inputs.forEach((x) => set.add(x % 42));
console.log(set.size);