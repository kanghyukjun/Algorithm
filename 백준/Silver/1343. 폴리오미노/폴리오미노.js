const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const map = fs.readFileSync(filePath, "utf-8").trim();

const A = map.replace(/XXXX/g, "AAAA");
const B = A.replace(/XX/g, "BB");

if (B.split("").find((val) => val === "X")) {
  console.log(-1);
} else {
  console.log(B);
}