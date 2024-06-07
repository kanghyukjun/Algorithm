// get input
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [K, inputs] = fs.readFileSync(filePath, "utf-8").split("\n");

// process
let input = inputs.split(" ");
let que = [];
que.push([0, input.length - 1]);
for (let i = 0; i < K; i++) {
  const length: number = Math.pow(2, i);
  let text: string = "";
  for (let i = 0; i < length; i++) {
    const cur: number[] | undefined = que.shift();
    if (typeof cur === "undefined") break;
    const mid: number = (cur[0] + cur[1]) / 2;
    text += `${input[mid]} `;
    que.push([cur[0], mid - 1]);
    que.push([mid + 1, cur[1]]);
  }
  console.log(text);
}