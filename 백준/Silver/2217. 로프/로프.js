const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n").map(Number);

inputs.sort((e1, e2) => e2 - e1);

let left = 0;
let right = 1000000000;
let output = 0;
while (left <= right) {
  const mid = Math.floor((left + right) / 2);
  if (isValid(inputs, mid)) {
    output = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}
console.log(output);

function isValid(inputs, weight) {
  let count = 1;
  for (const input of inputs) {
    if (weight / count > input) {
      count++;
    } else {
      return true;
    }
  }
  return false;
}