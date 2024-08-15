const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

let [x, y] = [1, 1];
let isRight = true;
for (let i = 0; i < N - 1; i++) {
  if (isRight && x == 1) {
    y++;
    isRight = !isRight;
    continue;
  } else if (!isRight && y == 1) {
    x++;
    isRight = !isRight;
    continue;
  }

  if (isRight) {
    x--;
    y++;
  } else {
    x++;
    y--;
  }
}
console.log(`${x}/${y}`);