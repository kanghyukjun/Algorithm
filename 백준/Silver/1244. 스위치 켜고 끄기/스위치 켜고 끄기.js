const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [n, arr, m, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const N = +n;
arr = [0, ...arr.split(" ").map(Number)];
const M = +m;
for (const input of inputs) {
  const [student, value] = input.split(" ").map(Number);
  if (student === 1) {
    for (let i = value; i < arr.length; i += value) {
      arr[i] = 1 - arr[i];
    }
  } else {
    let left = value;
    let right = value;
    while (left > 0 && right < arr.length && arr[left] === arr[right]) {
      left--;
      right++;
    }
    for (let i = left + 1; i < right; i++) {
      arr[i] = 1 - arr[i];
    }
  }
}

arr.shift();
let output = "";
slice(arr).forEach((x) => {
  output += x.join(" ");
  output += "\n";
});
console.log(output);

function slice(arr) {
  const output = [];
  for (let i = 0; i < arr.length; i += 20) {
    output.push(arr.slice(i, i + 20));
  }
  return output;
}