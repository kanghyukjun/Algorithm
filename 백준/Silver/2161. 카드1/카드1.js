const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const n = +fs.readFileSync(filePath, "utf-8").trim();

const arr = Array.from({ length: n }, (_, idx) => idx + 1);
let output = "";
while (arr.length > 1) {
  output += `${arr.shift()} `;
  arr.push(arr.shift());
}
console.log(`${output}${arr[0]}`);