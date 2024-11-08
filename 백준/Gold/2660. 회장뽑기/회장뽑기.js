const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

N = +N;
inputs.pop();
const neighbors = Array.from({ length: N + 1 }, () => new Set());
inputs
  .map((input) => input.split(" ").map(Number))
  .forEach(([e1, e2]) => {
    neighbors[e1].add(e2);
    neighbors[e2].add(e1);
  });

// 각 노드에서, 가장 멀리 떨어진 노드까지의 거리 구하기
const els = [];
Array.from({ length: N }, (_, idx) => idx + 1).forEach((node) => {
  const isChecked = new Array(N + 1).fill(false);
  isChecked[0] = true;
  isChecked[node] = true;

  const que = [node];
  let size = que.length;
  let count = 0;
  while (que.length > 0) {
    for (let i = 0; i < size; i++) {
      const current = que.shift();
      for (const el of neighbors[current]) {
        if (!isChecked[el]) {
          isChecked[el] = true;
          que.push(el);
        }
      }
    }
    size = que.length;
    count++;
  }
  els.push({
    node,
    count: count - 1,
  });
});

els.sort((e1, e2) => {
  if (e1.count !== e2.count) {
    return e1.count - e2.count;
  } else {
    return e1.node - e2.node;
  }
});

let min = els[0].count;
const output = [];
for (const el of els) {
  if (el.count > min) break;
  else output.push(el.node);
}

console.log(min, output.length);
console.log(output.join(" "));