const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const inputs = fs.readFileSync(filePath, "utf-8").trim().split("");

// <를 만나면 flag를 true로 바꾸고 <를 출력한다. 그 전까지 저장된 단어가 있다면 거꾸로 출력한다.
// >를 만나면 flag를 false로 바꾸고 >를 출력한다.
// " "를 만나고 flag가 false라면 그 전까지 저장한 문자를 거꾸로 출력한다
// flag가 false라면 문자를 저장하고, 그렇지 않다면 문자를 출력한다.

inputs.push(" ");
let flag = false;
let output = "";
const que = [];
for (const input of inputs) {
  if (input === "<") {
    flag = true;
    while (que.length > 0) {
      output += que.pop();
    }

    output += "<";
  } else if (input === ">") {
    flag = false;
    output += ">";
  } else if (input === " " && !flag) {
    while (que.length > 0) {
      output += que.pop();
    }
    output += " ";
  } else {
    if (flag) {
      output += input;
    } else {
      que.push(input);
    }
  }
}
console.log(output);