const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

class Heap {
  #arr;
  #idx;
  #comparator;

  constructor(comparator) {
    this.#arr = [0];
    this.#idx = 1;
    this.#comparator = comparator;
  }

  add = (num) => {
    this.#arr[this.#idx] = num;
    let idx = this.#idx;
    while (
      this.#comparator(this.#arr[Math.floor(idx / 2)], this.#arr[idx]) > 0 &&
      Math.floor(idx / 2) !== 0
    ) {
      const tmp = this.#arr[Math.floor(idx / 2)];
      this.#arr[Math.floor(idx / 2)] = this.#arr[idx];
      this.#arr[idx] = tmp;
      idx = Math.floor(idx / 2);
    }
    this.#idx++;
  };

  poll = () => {
    const output = this.#arr[1];
    this.#arr[1] = this.#arr[this.#idx - 1];
    let idx = 1;
    while (idx < this.#idx) {
      const leftChild = idx * 2;
      const rightChild = idx * 2 + 1;

      if (this.#arr[leftChild] === undefined && this.#arr[rightChild] === undefined) {
        break;
      } else if (this.#arr[leftChild] === undefined || this.#arr[rightChild] === undefined) {
        const validChild = this.#arr[leftChild] === undefined ? rightChild : leftChild;
        if (this.#comparator(this.#arr[idx], this.#arr[validChild]) > 0) {
          const tmp = this.#arr[validChild];
          this.#arr[validChild] = this.#arr[idx];
          this.#arr[idx] = tmp;
          idx = validChild;
        } else break;
      } else {
        const competitiveChild =
          this.#comparator(this.#arr[leftChild], this.#arr[rightChild]) < 0
            ? leftChild
            : rightChild;

        if (this.#comparator(this.#arr[idx], this.#arr[competitiveChild]) > 0) {
          const tmp = this.#arr[competitiveChild];
          this.#arr[competitiveChild] = this.#arr[idx];
          this.#arr[idx] = tmp;
          idx = competitiveChild;
        } else break;
      }
    }
    this.#idx--;
    this.#arr.length = this.#arr.length - 1;
    return output;
  };

  peek = () => {
    return this.#arr[1];
  };

  size = () => {
    return this.#arr.length - 1;
  };

  isEmpty = () => {
    return this.#arr.length === 1;
  };
}

const minHeap = new Heap((o1, o2) => o1 - o2);
let output = "";
for (const input of inputs) {
  const num = +input;

  if (num !== 0) {
    minHeap.add(num);
  } else {
    if (minHeap.isEmpty()) output += "0\n";
    else output += minHeap.poll() + "\n";
  }
}
console.log(output);