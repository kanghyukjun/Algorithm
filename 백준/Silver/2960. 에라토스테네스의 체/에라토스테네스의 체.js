const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, K] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

const arr = Array.from({ length: N + 1 }, (_, idx) => idx);

let count = 0;
let output = -1;
while (true) {
  let find = -1;
  for (let i = 2; i <= N; i++) {
    if (arr[i] !== 0) {
      find = i;
      break;
    }
  }

  for (let i = find; i <= N; i += find) {
    if (arr[i] === 0) continue;
    arr[i] = 0;
    count++;
    if (count === K) {
      output = i;
      break;
    }
  }
  if (output !== -1) break;
}

console.log(output);