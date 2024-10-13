const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

inputs.sort((input1, input2) => {
  const one = input1.split(" ").map(Number);
  const two = input2.split(" ").map(Number);

  for (let i = 0; i < 3; i++) {
    if (one[i] !== two[i]) return one[i] - two[i];
  }
  return 0;
});

let output = "";
inputs.forEach((x) => (output += `${x.split(" ").map(Number).join(" ")}\n`));
console.log(output);