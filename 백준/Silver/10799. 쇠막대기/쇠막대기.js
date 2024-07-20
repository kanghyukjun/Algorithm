const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const line = fs.readFileSync(filePath, "utf-8").trim();

// (를 만났을 때 만났음을 저장해둔다
// 이후 만난 것이 )가 아니라면 전체 막대의 갯수를 하나 증가시킨다
// 현재 진행중인 막대 갯수 역시 하나 증가시킨다
// 만난 것이 )라면 현재 진행중인 막대의 갯수만큼 전체 막대의 갯수를 증가시킨다
// ( 이후 바로 )를 만난 상황이 아닐 때 )를 만났다면 진행중인 막대의 갯수를 하나 감소시킨다

let currentBar = 0;
let sum = 0;
let before = "";
for (const el of line) {
  // 레이저
  if (before === "(" && el === ")") {
    sum += currentBar;
  }

  // 막대기 추가
  if (before === "(" && el === "(") {
    sum += 1;
    currentBar += 1;
  }

  // 현재 막대기 감소
  if (before === ")" && el === ")") {
    currentBar -= 1;
  }

  before = el;
}

console.log(sum);