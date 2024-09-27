const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [S, T] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

S = S.trim().split("");
T = T.trim().split("");

let isReversed = false;
while (T.length > S.length) {
  let idx = T[isReversed ? 0 : T.length - 1];

  if (isReversed) {
    T.shift();
  } else {
    T.pop();
  }
  if (idx === "B") isReversed = !isReversed;
}

if (isReversed) T.reverse();

console.log(S.join("") === T.join("") ? 1 : 0);