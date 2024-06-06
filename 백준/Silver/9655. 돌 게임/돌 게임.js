const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = fs.readFileSync(filePath, "utf-8").trim();

console.log(parseInt(N) % 2 ? "SK" : "CY");