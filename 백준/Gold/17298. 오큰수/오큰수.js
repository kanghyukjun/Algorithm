const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

class Stack {
  arr = [];

  size = () => {
    return this.arr.length;
  };

  isEmpty = () => {
    return this.arr.length === 0;
  };

  push = (num) => {
    this.arr.push(num);
  };

  pop = () => {
    return this.arr.pop();
  };

  peek = () => {
    return this.arr[this.arr.length - 1];
  };
}

const main = () => {
  const n = +N;
  const arr = inputs.split(" ").map(Number);

  const stk = new Stack();
  stk.push(arr[arr.length - 1]);
  const output = Array.from({ length: arr.length }, () => -1);

  for (let i = arr.length - 2; i >= 0; i--) {
    const current = arr[i];

    if (!stk.isEmpty()) {
      if (stk.peek() > current) {
        // 만약 스택의 top이 current보다 크다면 output[i] = stk.peek()
        // 그 후 스택에 current를 push한다
        output[i] = stk.peek();
      } else {
        // 만약 top보다 current가 크면 current보다 큰 stk의 top이 있을 때까지 pop을 한다
        // 만약 top을 찾으면 output[i] = stk.peek()
        // 스택에 current를 push한다
        while (!stk.isEmpty() && stk.peek() <= current) {
          stk.pop();
        }

        if (!stk.isEmpty()) output[i] = stk.peek();
      }
    }

    stk.push(current);
  }

  console.log(output.join(" "));
};

main();