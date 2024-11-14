const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("");

const arr = Array.from(
  { length: "z".charCodeAt(0) - "a".charCodeAt(0) + 1 },
  () => -1
);

inputs.forEach((x, idx) => {
  const index = getIndex(x);
  if (arr[index] === -1) {
    arr[index] = idx;
  }
});

console.log(arr.join(" "));

function getIndex(val) {
  return val.charCodeAt(0) - "a".charCodeAt(0);
}