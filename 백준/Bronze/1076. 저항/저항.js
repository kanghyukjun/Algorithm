const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [first, second, multi] = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n");

const map = new Map();
map.set("black", { value: 0, multiply: 1 });
map.set("brown", { value: 1, multiply: 10 });
map.set("red", { value: 2, multiply: 100 });
map.set("orange", { value: 3, multiply: 1_000 });
map.set("yellow", { value: 4, multiply: 10_000 });
map.set("green", { value: 5, multiply: 100_000 });
map.set("blue", { value: 6, multiply: 1_000_000 });
map.set("violet", { value: 7, multiply: 10_000_000 });
map.set("grey", { value: 8, multiply: 100_000_000 });
map.set("white", { value: 9, multiply: 1_000_000_000 });

console.log(
  (map.get(first.trim()).value * 10 + map.get(second.trim()).value) *
    map.get(multi.trim()).multiply
);