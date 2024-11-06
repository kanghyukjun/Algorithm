const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, arr] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
const A = arr.split(" ").map(Number);
const B = [...A].sort((e1, e2) => e1 - e2);
const stk = [];

B.forEach((x, idx) => {
  if (!stk[x]) stk[x] = [];
  stk[x].push(idx);
});

const output = [];
A.forEach((x) => {
  output.push(stk[x].shift());
});

console.log(output.join(" "));