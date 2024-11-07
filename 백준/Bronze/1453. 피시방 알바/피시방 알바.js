const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
inputs = inputs.split(" ").map(Number);

const set = new Set();
inputs.forEach((x) => set.add(x));

console.log(N - set.size);