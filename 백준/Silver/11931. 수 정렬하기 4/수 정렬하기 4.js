const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n").map(Number);

const input = inputs.sort((e1, e2) => e2 - e1);

console.log(input.join("\n"));