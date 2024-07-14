const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [nums, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const save = [];

const [N, M] = nums.split(" ").map(Number);
const arr = inputs
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);

let output = "";
solve(0);
console.log(output);

function solve(depth) {
  if (depth === M) {
    output += save.join(" ");
    output += "\n";
  } else {
    for (const el of arr) {
      save[depth] = el;
      solve(depth + 1);
    }
  }
}