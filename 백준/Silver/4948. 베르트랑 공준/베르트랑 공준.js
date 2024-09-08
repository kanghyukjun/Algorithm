const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("\n").map(Number);

const isSosu = Array.from({ length: 123456 * 2 + 1 }, () => true);
isSosu[0] = false;
isSosu[1] = false;
for (let i = 2; i < isSosu.length; i++) {
  if (isSosu[i]) {
    for (let j = i + i; j < isSosu.length; j += i) {
      isSosu[j] = false;
    }
  }
}

let output = "";
for (let i = 0; i < inputs.length - 1; i++) {
  const n = inputs[i];
  let count = 0;
  for (let j = n + 1; j <= 2 * n; j++) {
    if (isSosu[j]) count++;
  }
  output += `${count}\n`;
}
console.log(output);