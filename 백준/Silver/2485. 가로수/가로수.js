const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n").map(Number);

const diffArr = [];
for (let i = 0; i < inputs.length - 1; i++) {
  diffArr[i] = inputs[i + 1] - inputs[i];
}

let max = diffArr[0];
for (let i = 1; i < diffArr.length; i++) {
  max = getMin(max, diffArr[i]);
}

let count = 0;
for (let i = 0; i < diffArr.length; i++) {
  count += diffArr[i] / max - 1;
}
console.log(count);

function getMin(a, b) {
  let max = a > b ? a : b;
  let min = a > b ? b : a;

  while (max % min !== 0) {
    const rem = max % min;
    max = min;
    min = rem;
  }
  return min;
}