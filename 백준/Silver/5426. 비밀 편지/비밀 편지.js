const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [_, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
inputs.forEach((x) => {
  const input = x.trim().split("");
  const N = Math.sqrt(input.length);

  const arr = Array.from({ length: N }, () => new Array(N));
  let idx = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      arr[i][j] = input[idx++];
    }
  }

  for (let col = N - 1; col >= 0; col--) {
    for (let row = 0; row < N; row++) {
      output += arr[row][col];
    }
  }
  output += "\n";
});

console.log(output);