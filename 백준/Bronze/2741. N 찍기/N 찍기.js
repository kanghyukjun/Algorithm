const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = +fs.readFileSync(filePath, "utf-8").trim();

let output = "";
for (let i = 0; i < inputs; i++) {
  output += `${i + 1}\n`;
}
console.log(output);