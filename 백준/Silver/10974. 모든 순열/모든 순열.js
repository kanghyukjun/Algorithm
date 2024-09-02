const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const N = +fs.readFileSync(filePath, "utf-8").trim();

let output = "";
const save = [];
const isChecked = Array.from({ length: N + 1 }, () => false);
solve(0);
console.log(output);

function solve(depth) {
  if (depth === N) {
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
}