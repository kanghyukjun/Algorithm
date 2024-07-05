const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let [N, arr, M, has] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const map = new Map();
arr = arr.split(" ");
arr.forEach((x) => {
  const val = +x;
  if (map.has(val)) {
    count = map.get(val);
    map.set(val, count + 1);
  } else {
    map.set(val, 1);
  }
});

let output = "";
has = has.split(" ");
has.forEach((x) => {
  if (map.has(+x)) {
    output += `${map.get(+x)} `;
  } else {
    output += `0 `;
  }
});

console.log(output);