const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const map = new Map();
inputs.forEach((input) => {
  if (map.has(input)) {
    map.set(input, map.get(input) + 1);
  } else {
    map.set(input, 1);
  }
});

console.log(
  Array.from(map).sort((e1, e2) => {
    if (e1[1] === e2[1]) {
      return e1[0].localeCompare(e2[0]);
    }
    return e2[1] - e1[1];
  })[0][0]
);