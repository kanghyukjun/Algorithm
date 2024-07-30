const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim();

console.log(
  inputs
    .split("")
    .map(Number)
    .sort((e1, e2) => e2 - e1)
    .join("")
);