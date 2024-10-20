const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

let output = "";
Array.from({ length: N }, (_, idx) => idx + 1)
  .reverse()
  .forEach((x) => (output += `${x}\n`));

console.log(output);