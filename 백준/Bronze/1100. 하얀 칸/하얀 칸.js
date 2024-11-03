const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const map = fs.readFileSync(filePath, "utf-8").trim().split("\n");
map.forEach((x, idx, arr) => (arr[idx] = x.trim().split("")));

let count = 0;
map.forEach((row, rowIdx) => {
  row.forEach((col, colIdx) => {
    if ((rowIdx + colIdx) % 2 === 0 && map[rowIdx][colIdx] === "F") count++;
  });
});

console.log(count);