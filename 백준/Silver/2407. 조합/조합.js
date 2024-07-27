const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

let output = 1n;
for (let i = 0; i < M; i++) {
  output *= BigInt(N - i);
  output /= BigInt(i + 1);
}
console.log(output.toString());