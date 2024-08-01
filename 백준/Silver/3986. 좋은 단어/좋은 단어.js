const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let count = 0;
for (const input of inputs) {
  const stk = [];
  for (const c of input) {
    if (stk.length === 0) {
      stk.push(c);
    } else if (stk[stk.length - 1] === c) {
      stk.pop();
    } else {
      stk.push(c);
    }
  }
  if (stk.length === 0) count++;
}
console.log(count);