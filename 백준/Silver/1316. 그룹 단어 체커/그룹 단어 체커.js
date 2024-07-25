const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

// 시작할 때에는 이전 단어에 시작 단어를 기록해둠

// 이전 단어와 다르다면?
//     현재 단어를 확인
//     현재 단어의 checked가 true라면 실패

// 이전 단어의 checked = true로 만듬
// 현재 단어를 이전 단어로 기록해둠
// 이전 단어와 같다면 continue
// 한칸 옮김

let count = 0;
inputs.forEach((x) => {
  const checked = {};
  let before = x[0];
  let flag = true;
  for (const word of x) {
    if (word !== before) {
      if (checked[word]) {
        flag = false;
        break;
      }
      checked[before] = true;
      before = word;
    }
  }
  if (flag) {
    count++;
  }
});

console.log(count);