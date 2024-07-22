const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let [N, A, B] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

A = A.split(" ")
  .map(Number)
  .sort((e1, e2) => e2 - e1);
B = B.split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);

let output = 0;
for (let i = 0; i < N; i++) {
  output += A[i] * B[i];
}
console.log(output);