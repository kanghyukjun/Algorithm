const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [NUM, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = NUM.split(" ").map(Number);
inputs = inputs.map((input) => input.split(" ").map(Number));

const check = [];
let max = 0;
get(0, 0);
console.log(max);

function get(idx, depth) {
  if (depth === 3) {
    let sum = 0;
    for (let i = 0; i < N; i++) {
      sum += Math.max(
        inputs[i][check[0]],
        inputs[i][check[1]],
        inputs[i][check[2]]
      );
    }
    max = Math.max(max, sum);
  } else {
    for (let i = idx; i < M; i++) {
      check[depth] = i;
      get(i + 1, depth + 1);
    }
  }
}