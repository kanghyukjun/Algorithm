const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const input = fs.readFileSync(filePath, "utf-8").trim().split("");

const root = {
  isWord: false,
  childs: new Map(),
};
let count = 0;

for (let i = 0; i < input.length; i++) {
  let current = root;
  for (let j = i; j < input.length; j++) {
    const c = input[j];
    if (!current.childs.has(c)) {
      current.childs.set(c, { isWord: false, childs: new Map() });
    }

    current = current.childs.get(c);
    if (!current.isWord) {
      count++;
      current.isWord = true;
    }
  }
}

console.log(count);