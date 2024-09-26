const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
inputs.forEach((input) => {
  const [a, b] = input.split(" ").map(Number);
  const div = foo(a, b);
  const aDiv = a / div;
  const bDiv = b / div;
  output += `${aDiv * bDiv * div}\n`;
});

console.log(output);

function foo(a, b) {
  while (a % b !== 0) {
    const r = a % b;
    a = b;
    b = r;
  }
  return b;
}