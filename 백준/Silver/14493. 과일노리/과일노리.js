const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

inputs.forEach((x, idx, arr) => {
  arr[idx] = x.split(" ").map(Number);
});

// A초 간격으로 나타나 B초동안 탐지
// Time % (A + B) <= B

let time = 0;
let idx = 0;
while (idx < N) {
  const [A, B] = inputs[idx];
  if (time % (A + B) <= B) {
    time += B + 1 - (time % (A + B));
    idx++;
  } else {
    idx++;
    time++;
  }
}

console.log(time);