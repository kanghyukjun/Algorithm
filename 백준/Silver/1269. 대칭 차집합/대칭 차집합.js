const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [num, A, B] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = num.split(" ").map(Number);
A = A.split(" ").map(Number);
B = B.split(" ").map(Number);
const set = new Set();
A.forEach((x) => set.add(x));
B.forEach((x) => set.add(x));

const minus = A.length + B.length - set.size;
console.log(set.size - minus);