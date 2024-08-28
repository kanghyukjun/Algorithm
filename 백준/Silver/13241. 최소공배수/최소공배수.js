const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

console.log((N / GCD(N, M)) * M);

function GCD(n, m) {
  let r = 1;
  while (n % m !== 0) {
    r = n % m;
    n = m;
    m = r;
  }

  return m;
}