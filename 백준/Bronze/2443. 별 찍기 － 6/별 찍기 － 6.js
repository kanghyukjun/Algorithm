const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let inputs = +fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
Array.from({ length: inputs }, (_, idx) => inputs - idx - 1).forEach((val) => {
  output += `${" ".repeat(inputs - 1 - val)}${"*".repeat(val * 2 + 1)}\n`;
});

console.log(output);