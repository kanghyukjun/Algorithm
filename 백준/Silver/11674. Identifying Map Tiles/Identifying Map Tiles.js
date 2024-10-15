const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = fs.readFileSync(filePath, "utf-8").trim();

const arr = N.split("");
let size = 2 ** arr.length;

let [row, col] = [0, 0];
for (const el of arr) {
  if (el === "0") {
  } else if (el === "1") {
    col += size / 2;
  } else if (el === "2") {
    row += size / 2;
  } else {
    col += size / 2;
    row += size / 2;
  }
  size /= 2;
}

console.log(arr.length, col, row);