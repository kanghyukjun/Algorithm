const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let inputs = fs.readFileSync(filePath, "utf-8").trim();

const values = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];

values.forEach((value) => {
  const regex = new RegExp(value, "g");
  inputs = inputs.replace(regex, " ");
});

console.log(inputs.length);