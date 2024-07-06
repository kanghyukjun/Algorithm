const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

class Deque {
  arr;
  frontPointer;
  backPointer;

  constructor() {
    this.arr = [];
    this.frontPointer = 0;
    this.backPointer = 0;
  }

  push_front(value) {
    this.arr.unshift(value);
  }
  push_back(value) {
    this.arr.push(value);
  }
  pop_front() {
    return this.arr.shift();
  }
  pop_back() {
    return this.arr.pop();
  }
  size() {
    return this.arr.length;
  }
  empty() {
    return this.arr.length === 0;
  }
  front() {
    return this.arr[0];
  }
  back() {
    return this.arr[this.arr.length - 1];
  }
}

const deque = new Deque();
let output = "";
for (const order of inputs) {
  const [currentOrder, value] = order.split(" ");
  if (currentOrder === "push_front") {
    deque.push_front(+value);
  } else if (currentOrder === "push_back") {
    deque.push_back(+value);
  } else if (currentOrder === "pop_front") {
    if (deque.empty()) output += "-1\n";
    else output += `${deque.pop_front()}\n`;
  } else if (currentOrder === "pop_back") {
    if (deque.empty()) output += "-1\n";
    else output += `${deque.pop_back()}\n`;
  } else if (currentOrder === "size") {
    output += `${deque.size()}\n`;
  } else if (currentOrder === "empty") {
    output += `${deque.empty() ? 1 : 0}\n`;
  } else if (currentOrder === "front") {
    if (deque.empty()) output += "-1\n";
    else output += `${deque.front()}\n`;
  } else if (currentOrder === "back") {
    if (deque.empty()) output += "-1\n";
    else output += `${deque.back()}\n`;
  }
}

console.log(output);