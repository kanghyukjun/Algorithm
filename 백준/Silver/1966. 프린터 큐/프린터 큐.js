const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [TC, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const t = +TC;

let output = "";
for (let i = 0; i < t * 2; i += 2) {
  const [n, m] = inputs[i].split(" ").map(Number);
  let arr = inputs[i + 1].split(" ").map(Number);
  const sortedArr = [...arr].sort((e1, e2) => e2 - e1);
  arr = arr.map((value) => [value, false]);
  arr[m][1] = true;

  let count = 0;
  while (sortedArr.length !== 0 && arr.length !== 0) {
    if (sortedArr[0] === arr[0][0]) {
      sortedArr.shift();
      count++;
      if (arr[0][1]) {
        break;
      }
      arr.shift();
    } else {
      arr.push(arr.shift());
    }
  }
  output += `${count}\n`;
}
console.log(output);