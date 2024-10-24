const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";

console.log(
  fs
    .readFileSync(filePath, "utf-8")
    .trim()
    .split(" ")
    .map(Number)
    .sort((e1, e2) => e1 - e2)
    .join(" ")
);