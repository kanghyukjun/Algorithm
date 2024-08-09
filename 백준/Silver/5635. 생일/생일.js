const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

inputs.forEach((value, idx, arr) => (arr[idx] = value.split(" ")));
inputs.sort((e1, e2) => {
  for (let i = 3; i > 0; i--) {
    if (e1[i] === e2[i]) continue;
    return e1[i] - e2[i];
  }
});
console.log(`${inputs[N - 1][0]}\n${inputs[0][0]}`);