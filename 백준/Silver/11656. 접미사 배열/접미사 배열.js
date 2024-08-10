const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath, "utf-8").trim();

const arr = [];
input.split("").forEach((_, idx) => arr.push(input.slice(idx)));
console.log(arr.sort().join("\n"));