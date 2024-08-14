const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ");
console.log(N / M);