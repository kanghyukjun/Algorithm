const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [nums, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = nums.split(" ").map(Number);
const set = new Set();
const arr = inputs
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);

const save = [];
let output = "";
solve(0, 0);

for (const el of set) {
  output += `${el}\n`;
}
console.log(output);

function solve(idx, depth) {
  if (depth === M) {
    set.add(save.join(" "));
  } else {
    for (let i = idx; i < N; i++) {
      save[depth] = arr[i];
      solve(i + 1, depth + 1);
    }
  }
}