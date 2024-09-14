const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [A, B] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
B.split("")
  .reverse()
  .forEach((val) => (output += `${+val * +A}\n`));
output += `${+A * +B}`;
console.log(output);