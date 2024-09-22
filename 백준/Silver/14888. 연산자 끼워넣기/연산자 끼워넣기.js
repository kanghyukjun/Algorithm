const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, arr, count] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
N = +N;
arr = arr.split(" ").map(Number);
count = count.split(" ").map(Number);
save = [];
let min = Infinity;
let max = -Infinity;

get(0);

console.log(max === 0 ? 0 : max);
console.log(min === 0 ? 0 : min);

function get(depth) {
  if (depth === N - 1) {
    let sum = arr[0];
    for (let i = 1; i < N; i++) {
      sum = calculate(sum, arr[i], save[i - 1]);
    }

    min = Math.min(min, sum);
    max = Math.max(max, sum);
  } else {
    for (let i = 0; i < 4; i++) {
      if (count[i] === 0) continue;
      count[i]--;
      save[depth] = i;
      get(depth + 1);
      count[i]++;
    }
  }
}

function calculate(num1, num2, operator) {
  switch (operator) {
    case 0:
      return num1 + num2;
    case 1:
      return num1 - num2;
    case 2:
      return num1 * num2;
    case 3: {
      if (num1 < 0 && num2 > 0) {
        let output = Math.floor(-num1 / num2);
        return -output;
      }
      return Math.floor(num1 / num2);
    }
    default:
  }
}