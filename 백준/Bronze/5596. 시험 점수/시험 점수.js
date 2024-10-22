const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [o, t] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const o1 = o
  .split(" ")
  .map(Number)
  .reduce((acc, val) => acc + val);
const t1 = t
  .split(" ")
  .map(Number)
  .reduce((acc, val) => acc + val);
console.log(o1 < t1 ? t1 : o1);