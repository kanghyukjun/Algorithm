const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

let output = "";
for (let tc = 0; tc < N; tc++) {
  const [x1, y1, r1, x2, y2, r2] = inputs[tc].split(" ").map(Number);

  const distancePow = getDistancePow(x1, y1, x2, y2);
  const radiusSumPow = getPow(r1 + r2);
  const radiusMinusPow = getPow(r1 - r2);

  if (distancePow === 0) {
    if (r1 === r2) {
      output += "-1\n";
    } else {
      output += "0\n";
    }
    continue;
  }

  if (radiusSumPow < distancePow) {
    output += "0\n";
    continue;
  }

  if (radiusSumPow === distancePow || radiusMinusPow === distancePow) {
    output += "1\n";
    continue;
  }

  if (Math.sqrt(distancePow) + (r1 < r2 ? r1 : r2) < (r1 < r2 ? r2 : r1)) {
    output += "0\n";
    continue;
  }

  output += "2\n";
}

console.log(output);

function getDistancePow(x1, y1, x2, y2) {
  return (x1 - x2) ** 2 + (y1 - y2) ** 2;
}

function getPow(value) {
  return value ** 2;
}