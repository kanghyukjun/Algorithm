const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [nums, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = nums.split(" ").map(Number);
const arr = inputs
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);

const save = [];
let output = "";

const solve = (idx, depth) => {
  if (depth === M) {
    for (let i = 0; i < M; i++) {
      output += `${save[i]} `;
    }
    output += "\n";
  } else {
    for (let i = idx; i < N; i++) {
      save[depth] = arr[i];
      solve(i + 1, depth + 1);
    }
  }
};

solve(0, 0);
console.log(output);