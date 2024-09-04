const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [one, two] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

one = one.split(" ").map(Number);
two = two.split(" ").map(Number);

let parent = one[1] * two[1];
let son = two[1] * one[0] + one[1] * two[0];

let div = 2;

while (div <= son) {
  if (parent % div === 0 && son % div === 0) {
    parent /= div;
    son /= div;
  } else {
    div++;
  }
}

console.log(son, parent);