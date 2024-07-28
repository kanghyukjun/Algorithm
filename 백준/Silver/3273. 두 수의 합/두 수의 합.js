const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [n, arr, f] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const N = +n;
arr = arr
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);
const F = +f;

let left = 0;
let right = arr.length - 1;

let count = 0;
while (left < right) {
  if (arr[left] + arr[right] === F) {
    count++;
    left++;
    right++;
  } else if (arr[left] + arr[right] < F) {
    left++;
  } else {
    right--;
  }
}

console.log(count);