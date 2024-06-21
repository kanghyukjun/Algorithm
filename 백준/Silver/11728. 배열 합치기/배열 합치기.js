const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [nums, A, B] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  const [N, M] = nums.split(" ").map(Number);
  const a = A.split(" ").map(Number);
  const b = B.split(" ").map(Number);

  let aP = 0;
  let bP = 0;
  const output = [];

  while (aP < a.length && bP < b.length) {
    if (a[aP] < b[bP]) {
      output.push(a[aP]);
      aP++;
    } else {
      output.push(b[bP]);
      bP++;
    }
  }

  if (aP === a.length) {
    while (bP < b.length) {
      output.push(b[bP]);
      bP++;
    }
  } else {
    while (aP < a.length) {
      output.push(a[aP]);
      aP++;
    }
  }

  console.log(output.join(" "));
};

main();