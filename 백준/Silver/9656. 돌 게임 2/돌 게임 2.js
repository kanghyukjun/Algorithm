const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = +fs.readFileSync(filePath, "utf-8").trim();
console.log(inputs % 2 === 0 ? "SK" : "CY");