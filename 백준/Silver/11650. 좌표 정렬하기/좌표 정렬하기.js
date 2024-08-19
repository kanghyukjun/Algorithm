const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");
console.log(
  inputs
    .sort((e1, e2) => {
      const [x1, y1] = e1.split(" ").map(Number);
      const [x2, y2] = e2.split(" ").map(Number);
      if (x1 === x2) {
        return y1 - y2;
      }
      return x1 - x2;
    })
    .join("\n")
);