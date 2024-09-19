const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [H, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

let minutes = 60 * H + M - 45;
if (minutes < 0) minutes += 24 * 60;
console.log(`${Math.floor(minutes / 60)} ${minutes % 60}`);