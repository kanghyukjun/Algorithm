const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [TC, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
TC = +TC;

let output = "";
for (let i = 0; i < TC * 3; i += 3) {
  const [N, M] = inputs[i].split(" ").map(Number);
  const A = inputs[i + 1]
    .split(" ")
    .map(Number)
    .sort((e1, e2) => e1 - e2);
  const B = inputs[i + 2]
    .split(" ")
    .map(Number)
    .sort((e1, e2) => e1 - e2);

  let count = 0;
  A.forEach((x) => {
    for (const el of B) {
      if (x > el) count++;
      else break;
    }
  });
  output += `${count}\n`;
}

console.log(output);