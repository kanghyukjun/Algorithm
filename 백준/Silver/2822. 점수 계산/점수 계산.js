const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const idxs = [];
const sum = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n")
  .map(Number)
  .map((value, idx) => {
    return { value, idx: idx + 1 };
  })
  .sort((e1, e2) => e2.value - e1.value)
  .reduce((acc, cur, idx) => {
    if (idx < 5) {
      idxs.push(cur.idx);
      return acc + cur.value;
    }
    return acc;
  }, 0);

console.log(sum);
console.log(idxs.sort((e1, e2) => e1 - e2).join(" "));