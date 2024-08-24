const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [zero, one] = [0, 0];
const inputs = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("")
  .filter((value, idx, arr) => value !== arr[idx - 1])
  .forEach((val) => {
    if (val === "1") zero++;
    else one++;
  });
console.log(Math.min(zero, one));