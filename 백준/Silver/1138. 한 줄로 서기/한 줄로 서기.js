const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
inputs = inputs
  .split(" ")
  .map((val, idx) => ({
    length: idx + 1,
    count: +val,
  }))
  .sort((e1, e2) => e1.length - e2.length);

const output = Array.from({ length: N }, () => 0);
for (const input of inputs) {
  let count = -1;
  let i;
  for (i = 0; i < N; i++) {
    if (output[i] === 0) count++;
    if (count === input.count) break;
  }

  while (output[i] !== 0) i++;
  output[i] = input.length;
}

console.log(output.join(" "));