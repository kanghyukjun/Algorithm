const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [nums, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let sum = 0;
inputs.forEach((input, idx, arr) => {
  arr[idx] = input
    .split(" ")
    .map((value) => {
      const nValue = +value;
      sum += nValue;
      return nValue;
    })
    .sort((e1, e2) => e1 - e2);
});

let disCount = 0;
while (inputs[0].length > 0 && inputs[1].length > 0 && inputs[2].length > 0) {
  let sum = 0;
  sum += inputs[0].pop();
  sum += inputs[1].pop();
  sum += inputs[2].pop();

  disCount += sum * 0.9;
}

while (inputs[0].length > 0) {
  disCount += inputs[0].pop();
}
while (inputs[1].length > 0) {
  disCount += inputs[1].pop();
}
while (inputs[2].length > 0) {
  disCount += inputs[2].pop();
}

console.log(`${sum}\n${disCount}`);