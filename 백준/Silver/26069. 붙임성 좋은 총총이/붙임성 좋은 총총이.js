const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
const set = new Set();
set.add("ChongChong");

inputs.forEach((input) => {
  const [p1, p2] = input.trim().split(" ");
  if (set.has(p1) || set.has(p2)) {
    set.add(p1);
    set.add(p2);
  }
});

console.log(set.size);