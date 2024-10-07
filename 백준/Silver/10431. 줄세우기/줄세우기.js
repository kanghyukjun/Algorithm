const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
inputs.forEach((input) => {
  const [T, ...arr] = input.split(" ").map(Number);
  let count = 0;

  const line = [0];
  arr.forEach((child) => {
    let idx = -1;
    for (let i = 0; i < line.length; i++) {
      if (line[i] > child) {
        idx = i;
        break;
      }
    }

    if (idx === -1) {
      line.push(child);
    } else {
      const length = line.length;
      line.splice(idx, 0, child);
      count += length - idx;
    }
  });

  output += `${T} ${count}\n`;
});

console.log(output);