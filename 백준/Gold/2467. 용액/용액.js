const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
N = +N;
inputs = inputs.split(" ").map(Number);

let left = 0;
let right = N - 1;
const output = [1_000_000_001, 1_000_000_001];

while (left < right) {
  const sum = inputs[left] + inputs[right];
  if (Math.abs(sum) < Math.abs(output[0] + output[1])) {
    output[0] = inputs[left];
    output[1] = inputs[right];
  }

  if (sum > 0) {
    right--;
  } else if (sum < 0) {
    left++;
  } else {
    left++;
    right--;
  }
}

console.log(output.join(" "));