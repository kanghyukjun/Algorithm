const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [A, B] = fs.readFileSync(filePath, "utf-8").trim().split(" ");

let min = Infinity;
for (let i = 0; i < B.length; i++) {
  const get = find(A, i, B);
  if (get !== -1) min = Math.min(min, get);
}

console.log(min);

function find(A, index, B) {
  let count = 0;
  for (let i = 0; i < A.length; i++) {
    if (i + index >= B.length) return -1;
    if (A[i] !== B[i + index]) count++;
  }
  return count;
}