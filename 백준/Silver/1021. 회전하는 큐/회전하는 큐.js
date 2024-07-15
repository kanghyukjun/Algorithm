const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [nums, arr] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [N, M] = nums.split(" ").map(Number);
const result = arr.split(" ").map(Number);
let deque = Array.from({ length: N }, (value, idx) => idx + 1);

let output = 0;
for (const el of result) {
  const [left, right] = [[...deque], [...deque]];

  let [leftCount, rightCount] = [0, 0];
  while (left[0] !== el) {
    leftCount++;
    left.push(left.shift());
  }
  left.shift();

  while (right[0] !== el) {
    rightCount++;
    right.unshift(right.pop());
  }
  right.shift();

  if (leftCount < rightCount) {
    output += leftCount;
    deque = [...left];
  } else {
    output += rightCount;
    deque = [...right];
  }
}
console.log(output);