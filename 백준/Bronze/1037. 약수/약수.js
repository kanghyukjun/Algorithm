const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, nums] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
nums = nums
  .split(" ")
  .map(Number)
  .sort((e1, e2) => e1 - e2);
console.log(nums[0] * nums[nums.length - 1]);