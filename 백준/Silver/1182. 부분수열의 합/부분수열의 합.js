const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [nums, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, target] = nums.split(" ").map(Number);
inputs = inputs.split(" ").map(Number);

let output = 0;

for (let i = 1; i <= N; i++) {
  foo(0, 0, i, 0);
}
console.log(output);

function foo(idx, depth, end, sum) {
  if (depth === end) {
    if (sum === target) output++;
  } else {
    for (let i = idx; i < N; i++) {
      foo(i + 1, depth + 1, end, sum + inputs[i]);
    }
  }
}