const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("\n");
inputs.pop();

let output = "";
inputs.forEach((x) => {
  const arr = x.trim().split("").map(Number);

  let sum = arr.reduce((acc, val) => {
    if (val === 1) {
      return acc + 2;
    } else if (val === 0) {
      return acc + 4;
    }
    return acc + 3;
  }, 0);
  sum += arr.length + 1;
  output += `${sum}\n`;
});

console.log(output);