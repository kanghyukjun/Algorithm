const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, nums, M, ...inputs] = fs.readFileSync(filePath, "utf-8").split("\n");

const arr = nums.split(" ").map(Number);
let arrSum = Array.from(Array(N + 1), () => 0);
for (let i = 0; i < arr.length; i++) {
  arrSum[i + 1] = arrSum[i] + arr[i];
}

let output = "";
for (let i = 0; i < M; i++) {
  const [from, to] = inputs[i].split(" ").map(Number);
  output += `${arrSum[to] - arrSum[from - 1]}\n`;
}
console.log(output);