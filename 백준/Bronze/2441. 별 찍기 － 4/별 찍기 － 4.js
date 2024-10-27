const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = +fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
Array.from({ length: inputs }, (_, idx) => inputs - idx).forEach((x) => {
  output += `${" ".repeat(inputs - x)}${"*".repeat(x)}\n`;
});
console.log(output);