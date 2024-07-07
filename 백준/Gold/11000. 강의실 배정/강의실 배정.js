const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [N, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

class Heap {
  #arr;
  #idx;
  #comparator;

  constructor(comparator) {
    if (typeof comparator !== "function") throw new Error("comparator is not a function");

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
    if (this.isEmpty()) throw new Error("heap is empty");

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
    if (this.isEmpty()) throw new Error("heap is empty");
    return this.#arr[1];
  };

  size = () => {
    return this.#arr.length - 1;
  };

  isEmpty = () => {
    return this.#arr.length === 1;
  };
}

const lecturePQ = new Heap((e1, e2) => {
  if (e1[0] != e2[0]) return e1[0] - e2[0];
  return e1[1] - e2[1];
});

const room = new Heap((e1, e2) => e1 - e2);
room.add(0);

for (input of inputs) {
  lecturePQ.add(input.split(" ").map(Number));
}

while (!lecturePQ.isEmpty()) {
  const [s, e] = lecturePQ.poll();
  if (room.peek() <= s) {
    room.poll();
    room.add(e);
  } else {
    room.add(e);
  }
}
console.log(room.size());