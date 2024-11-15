const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
inputs.forEach((x) => {
  const [min, max] = x.split(" ").map(Number);
  let count = 0;
  for (let i = min; i <= max; i++) {
    if (check(i)) count++;
  }
  output += `${count}\n`;
});

console.log(output);

function check(num) {
  const isChecked = Array.from({ length: 10 }, () => false);
  while (num > 0) {
    const cur = num % 10;

    if (!isChecked[cur]) {
      isChecked[cur] = true;
    } else {
      return false;
    }

    num = Math.floor(num / 10);
  }
  return true;
}