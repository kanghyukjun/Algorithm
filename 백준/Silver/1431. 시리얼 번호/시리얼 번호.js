const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

inputs.forEach((val, idx, arr) => (arr[idx] = val.trim()));

console.log(
  inputs
    .sort((e1, e2) => {
      if (e1.length !== e2.length) {
        return e1.length - e2.length;
      } else {
        const e1Sum = e1.split("").reduce((acc, val) => {
          if (isNumber(val)) {
            return acc + +val;
          }
          return acc;
        }, 0);
        const e2Sum = e2.split("").reduce((acc, val) => {
          if (isNumber(val)) {
            return acc + +val;
          }
          return acc;
        }, 0);

        if (e1Sum !== e2Sum) {
          return e1Sum - e2Sum;
        } else {
          for (let i = 0; i < e1.length; i++) {
            const e1Char = e1[i];
            const e2Char = e2[i];

            if (isNumber(e1Char) && !isNumber(e2Char)) {
              return -1;
            } else if (!isNumber(e1Char) && isNumber(e2Char)) {
              return 1;
            } else if (isNumber(e1Char) && isNumber(e2Char) && e1Char !== e2Char) {
              return e1Char - e2Char;
            } else if (!isNumber(e1Char) && !isNumber(e2Char) && e1Char !== e2Char) {
              return e1Char.localeCompare(e2Char);
            }
          }
          return 0;
        }
      }
    })
    .join("\n")
);

function isNumber(val) {
  return "0" <= val && val <= "9";
}