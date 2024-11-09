const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
N = +N;

let output = "";
inputs.forEach((input) => {
  const arr = input.split(" ").map(Number);

  let max = -Infinity;
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      max = Math.max(max, getGCD(arr[i], arr[j]));
    }
  }
  output += `${max}\n`;
});

console.log(output);

function getGCD(a, b) {
  let c = a % b;
  while (a % b !== 0) {
    c = a % b;
    a = b;
    b = c;
  }
  return b;
}