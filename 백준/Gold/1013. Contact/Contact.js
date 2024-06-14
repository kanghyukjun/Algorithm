const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...lines] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const main = () => {
  let output = [];
  for (const line of lines) {
    // process
    const isOkay = solve(line);
    output.push(isOkay ? "YES" : "NO");
  }
  lines.forEach((line) => {});

  // output
  console.log(output.join("\n"));
};

const solve = (line) => {
  let start = 0;
  let last = 0;
  while (last < line.length) {
    if (line[start] === "1") {
      last++;
      let zeroCount = 0;
      while (last < line.length && line[last] === "0") {
        last++;
        zeroCount++;
      }
      if (last === line.length || zeroCount < 2) return false;

      let oneCount = 0;
      while (last < line.length && line[last] === "1") {
        last++;
        oneCount++;
      }
      if (oneCount < 0) return false;
      if (last === line.length) return true;

      if (oneCount === 1) start = last;
      if (oneCount > 1) {
        if (line.length > last + 1 && line[last + 1] == "1") {
          last += 2;
          start = last;
        } else {
          last--;
          start = last;
        }
      }
    }
    // 01 패턴일 때
    else if (line[start] === "0") {
      last++;
      if (line[last] === "1") {
        last++;
        start = last;
      } else {
        return false;
      }
    }
  }
  return true;
};

main();