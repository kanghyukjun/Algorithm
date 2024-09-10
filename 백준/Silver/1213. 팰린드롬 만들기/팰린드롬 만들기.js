const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("");

const count = Array.from(
  { length: "Z".charCodeAt(0) - "A".charCodeAt(0) + 1 },
  () => 0
);

const getAlphabet = (index) => String.fromCharCode("A".charCodeAt(0) + index);

inputs.forEach((x) => count[x.charCodeAt(0) - "A".charCodeAt(0)]++);

let output = "";
let middleWord = "";

for (let i = 0; i < count.length; i++) {
  const el = count[i];
  if (el === 0) continue;

  if (el % 2 === 1) {
    if (middleWord === "") {
      middleWord = getAlphabet(i);
      for (let j = 0; j < (el - 1) / 2; j++) {
        output += getAlphabet(i);
      }
    } else {
      console.log("I'm Sorry Hansoo");
      return;
    }
  } else {
    for (let j = 0; j < el / 2; j++) {
      output += getAlphabet(i);
    }
  }
}

console.log(output + middleWord + [...output].reverse().join(""));