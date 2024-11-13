const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [NN, IN] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const mapper = {
  A: 3,
  B: 2,
  C: 1,
  D: 2,
  E: 4,
  F: 3,
  G: 1,
  H: 3,
  I: 1,
  J: 1,
  K: 3,
  L: 1,
  M: 3,
  N: 2,
  O: 1,
  P: 2,
  Q: 2,
  R: 2,
  S: 1,
  T: 2,
  U: 1,
  V: 1,
  W: 1,
  X: 2,
  Y: 2,
  Z: 1,
};

const [N, M] = NN.split(" ").map(Number);
const [first, second] = IN.split(" ").map((val) => val.trim().split(""));

const output = [];
let idx = 0;
while (idx < first.length && idx < second.length) {
  output.push(first[idx]);
  output.push(second[idx]);
  idx++;
}

while (idx < first.length) {
  output.push(first[idx]);
  idx++;
}

while (idx < second.length) {
  output.push(second[idx]);
  idx++;
}

let result = output.map((val) => mapper[val]);
let tmp = [];
while (result.length !== 2) {
  let idx = 0;
  while (idx < result.length - 1) {
    tmp.push((result[idx] + result[idx + 1]) % 10);
    idx++;
  }
  result = tmp;
  tmp = [];
}

console.log(`${result[0] * 10 + result[1]}%`);