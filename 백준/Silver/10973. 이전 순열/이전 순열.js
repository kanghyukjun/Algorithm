const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, input] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
N = +N;

console.log(getPrev(input.split(" ").map(Number)).join(" "));

function getPrev(arr) {
  let idx = arr.length - 1;
  while (idx > 0 && arr[idx - 1] <= arr[idx]) {
    idx--;
  }
  if (idx === 0) return [-1];

  let j = arr.length - 1;
  while (arr[j] >= arr[idx - 1]) {
    j--;
  }

  const tmp = arr[idx - 1];
  arr[idx - 1] = arr[j];
  arr[j] = tmp;

  const reverse = arr.slice(idx).reverse();

  return [...arr.slice(0, idx), ...reverse];
}