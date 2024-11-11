const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const arr = fs.readFileSync(filePath, "utf-8").trim().split("").map(Number);

console.log(getNextPermutation(arr).join(""));

function getNextPermutation(arr) {
  let idx = arr.length - 1;
  while (idx - 1 >= 0 && arr[idx - 1] >= arr[idx]) {
    idx--;
  }

  if (idx === 0) return [0];
  const pivot = idx - 1;

  let rightIdx = arr.length - 1;
  while (rightIdx > pivot) {
    if (arr[rightIdx] > arr[pivot]) break;
    rightIdx--;
  }

  const tmp = arr[pivot];
  arr[pivot] = arr[rightIdx];
  arr[rightIdx] = tmp;

  return [...arr.slice(0, pivot + 1), ...arr.slice(pivot + 1).reverse()];
}