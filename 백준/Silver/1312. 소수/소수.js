const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let [A, B, N] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

if (A >= B) A %= B;

let output = -1;
while (N-- > 0) {
  A *= 10;
  output = Math.floor(A / B);
  A %= B;
}

console.log(output);