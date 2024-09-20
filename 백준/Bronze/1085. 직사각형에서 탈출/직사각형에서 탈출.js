const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [x, y, w, h] = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split(" ")
  .map(Number);
console.log(Math.min(x, y, w - x, h - y));