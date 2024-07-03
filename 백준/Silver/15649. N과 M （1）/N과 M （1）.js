const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

const solve = (depth) => {
  if (depth === M) {
    output += save.join(" ");
    output += "\n";
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (!isChecked[i]) {
      isChecked[i] = true;
      save[depth] = i;
      solve(depth + 1);
      isChecked[i] = false;
    }
  }
};

const isChecked = new Array(N + 1).fill(false);
const save = new Array(M).fill(0);
let output = "";

solve(0);

console.log(output);