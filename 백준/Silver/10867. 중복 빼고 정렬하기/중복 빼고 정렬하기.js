const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const set = new Set(inputs.split(" ").map(Number));
console.log([...set].sort((e1, e2) => e1 - e2).join(" "));