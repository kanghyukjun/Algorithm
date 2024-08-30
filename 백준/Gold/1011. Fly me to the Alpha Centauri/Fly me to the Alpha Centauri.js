const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [T, ...tc] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
tc.forEach((val) => {
  const [start, end] = val.split(" ").map(Number);
  const gap = end - start;

  const sqrt = Math.sqrt(gap);
  if (sqrt % 1 === 0) {
    output += `${sqrt * 2 - 1}\n`;
  } else {
    const minSqrt = Math.floor(sqrt);
    const maxSqrt = minSqrt + 1;
    if (gap > (minSqrt ** 2 + maxSqrt ** 2) / 2) {
      output += `${minSqrt * 2 + 1}\n`;
    } else {
      output += `${minSqrt * 2}\n`;
    }
  }
});

console.log(output);