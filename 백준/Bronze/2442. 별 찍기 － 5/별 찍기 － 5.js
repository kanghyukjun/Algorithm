const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = +fs.readFileSync(filePath, "utf-8").trim();

let output = "";
Array.from({ length: inputs }, (_, idx) => idx).forEach(
  (x) => (output += `${" ".repeat(inputs - x - 1)}${"*".repeat(x * 2 + 1)}\n`)
);
console.log(output);