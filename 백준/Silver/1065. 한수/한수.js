const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

const solve = (num) => {
  let flag = true;

  let cur = num % 10;
  num = Math.floor(num / 10);
  const diff = (num % 10) - cur;
  cur = num % 10;
  num = Math.floor(num / 10);

  while (num > 0) {
    if ((num % 10) - cur !== diff) return false;
    cur = num % 10;
    num = Math.floor(num / 10);
  }

  return flag;
};

let count = 0;
for (let num = 1; num <= N; num++) {
  if (solve(num)) count++;
}
console.log(count);