const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [inputs, arr] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = inputs.split(" ").map(Number);
const nums = arr
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);

const set = new Set();
const save = [];
solve(0);
console.log(Array.from(set).join("\n"));

function solve(depth) {
  if (depth === M) {
    set.add(save.join(" "));
  } else {
    for (const num of nums) {
      save[depth] = num;
      solve(depth + 1);
    }
  }
}