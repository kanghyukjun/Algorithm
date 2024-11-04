const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, jimin, hansu] = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split(" ")
  .map(Number);

let output = 0;
while (jimin !== hansu && jimin > 0 && hansu > 0) {
  jimin = Math.ceil(jimin / 2);
  hansu = Math.ceil(hansu / 2);
  output++;
}

console.log(jimin > 0 ? output : -1);