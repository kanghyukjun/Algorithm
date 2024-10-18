const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [TC, ...inputs]: number[] = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n")
  .map(Number);

const map: number[][] = Array.from({ length: 15 }, () => []);
map[0] = Array.from({ length: 15 }, (_, idx) => idx);

for (let i = 1; i < 15; i++) {
  for (let j = 0; j < 15; j++) {
    map[i][j] = (j - 1 < 0 ? 0 : map[i][j - 1]) + map[i - 1][j];
  }
}

let output = "";
for (let i = 0; i < TC * 2; i += 2) {
  const k = inputs[i];
  const n = inputs[i + 1];
  output += `${map[k][n]}\n`;
}
console.log(output);