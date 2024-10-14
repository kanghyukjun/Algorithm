const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim().split("\n");

console.log(
  Array.from({ length: N }, (_, idx) => idx + 1)
    .map((value) => "*".repeat(value))
    .join("\n")
);