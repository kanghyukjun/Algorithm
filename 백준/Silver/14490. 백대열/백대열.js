const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(":").map(Number);

let div = foo(N, M);
console.log([N / div, M / div].join(":"));

function foo(x, y) {
  while (x % y !== 0) {
    let r = x % y;
    x = y;
    y = r;
  }
  return y;
}