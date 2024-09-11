const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
console.log(fs.readFileSync(filePath, "utf-8").trim().split("").length);