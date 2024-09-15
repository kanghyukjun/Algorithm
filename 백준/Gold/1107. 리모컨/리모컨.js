const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [to, N, checked] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

to = +to;
N = +N;
const isDisabled = Array.from({ length: 10 }, () => false);
if (checked) {
  checked.split(" ").forEach((x) => (isDisabled[+x] = true));
}

// 사용할 수 있는 숫자를 이용해서 만들어낼 수 있는 최소 1부터 최대 6자리의 수를 만들어낸다
// 위의 모든 수와 to를 뺀 값의 절댓값과 from에서 to를 뺀 값의 절댓값을 모두 비교해서 가장 작은 수를 출력한다
const save = [];
let tmp = [];
for (let length = 1; length <= 6; length++) {
  tmp = [];
  getNumbers(0, length);
}

let output = Infinity;
save.forEach(({ value, count }) => {
  output = Math.min(output, Math.abs(value - to) + count);
});

output = Math.min(output, Math.abs(100 - to));
console.log(output);

function getNumbers(depth, maxDepth) {
  if (depth === maxDepth) {
    const value = +tmp.join("");
    save.push({ value, count: maxDepth });
  } else {
    for (let i = 0; i < 10; i++) {
      if (!isDisabled[i]) {
        tmp[depth] = i;
        getNumbers(depth + 1, maxDepth);
      }
    }
  }
}