const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const map = Array.from({ length: 100 }, () => new Array(100).fill(false));
inputs.forEach((value) => {
  const [x1, y1, x2, y2] = value.split(" ").map(Number);

  for (let i = x1; i < x2; i++) {
    for (let j = y1; j < y2; j++) {
      map[i][j] = true;
    }
  }
});

let count = 0;
map.forEach((row) =>
  row.forEach((val) => {
    if (val) count++;
  })
);

console.log(count);