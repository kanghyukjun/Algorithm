const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs
  .readFileSync(filePath, "utf-8")
  .trim()
  .split("\n")
  .map(Number);

const isSosu = Array.from({ length: 10001 }, () => true);
isSosu[0] = false;
isSosu[1] = false;
for (let i = 2; i < isSosu.length; i++) {
  if (!isSosu[i]) continue;

  for (let j = i * 2; j < isSosu.length; j += i) {
    isSosu[j] = false;
  }
}

const sosus = isSosu
  .map((value, idx) => (value ? idx : -1))
  .filter((value) => value !== -1);

let output = "";
inputs.forEach((x) => {
  let finds = [-1, -1];

  let i = 0;
  while (sosus[i] <= x / 2) {
    const left = sosus[i];
    const right = x - sosus[i];
    if (isSosu[right]) {
      finds[0] = left;
      finds[1] = right;
    }
    i++;
  }

  output += `${finds.join(" ")}\n`;
});
console.log(output);