const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

let output = "";
for (let i = 0; i < N; i++) {
  for (let j = i; j < N; j++) {
    output += "*";
  }
  output += "\n";
}

console.log(output);