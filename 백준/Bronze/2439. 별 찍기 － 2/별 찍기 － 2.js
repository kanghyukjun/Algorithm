const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

let output = "";
for (let i = 0; i < N; i++) {
  const space = N - i - 1;
  const word = i + 1;

  for (let j = 0; j < space; j++) output += " ";
  for (let j = 0; j < word; j++) output += "*";
  output += "\n";
}
console.log(output);