const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [n, ...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const N = +n;

const map = Array.from({ length: N + 1 }, () => new Array(N + 1).fill(0));
const K = +inputs[0];
for (let i = 1; i <= K; i++) {
  const [row, col] = inputs[i].split(" ").map(Number);
  map[row][col] = -1; // 사과의 위치
}

const dirChange = inputs.slice(K + 2);
dirChange.forEach((value, index, arr) => (arr[index] = value.trim().split(" ")));

let dirChangeIndex = 0;

// 1 : 오른쪽
// 2 : 아래
// 3 : 왼쪽
// 4 : 위쪽

const dir = [
  [0, 0],
  [0, 1],
  [1, 0],
  [0, -1],
  [-1, 0],
];
let dirIndex = 1;
const head = [1, 1];
const tail = [1, 1];
let count = 0;

// 몸을 현재 dirIndex 방향으로 하나 증가시킨다
// 유효한지 판단을 한다. 유효하지 않다면 게임을 종료시킨다
// 현재 시간에 방향을 바꾸는지 확인한다. 그렇다면 방향을 바꾸고 dirChangeIndex를 하나 증가시킨다.
// 현재 칸에 사과가 있는지 확인한다. 있다면 현재 칸을 dirIndex로 바꾼다.
// 사과가 없다면 꼬리를 이동시킨다
// 꼬리의 위치가 tRow, tCol이라고 할 때, map[tRow][tCol]의 방향으로 꼬리를 이동시키고 map[tRow][tCol]을 0으로 초기화한다.
map[1][1] = dirIndex;
while (true) {
  count++;
  head[0] += dir[dirIndex][0];
  head[1] += dir[dirIndex][1];
  if (!isValid(head[0], head[1])) break;

  if (dirChangeIndex < dirChange.length && count === +dirChange[dirChangeIndex][0]) {
    const rotateDirection = dirChange[dirChangeIndex][1];
    dirChangeIndex++;
    if (rotateDirection === "D") {
      dirIndex = D(dirIndex);
    } else {
      dirIndex = L(dirIndex);
    }
  }

  if (map[head[0]][head[1]] !== -1) {
    const [tRow, tCol] = tail;
    const currentDir = map[tRow][tCol];
    tail[0] += dir[currentDir][0];
    tail[1] += dir[currentDir][1];
    map[tRow][tCol] = 0;
  }
  map[head[0]][head[1]] = dirIndex;
}

console.log(count);

function isValid(row, col) {
  return 1 <= row && row <= N && 1 <= col && col <= N && (map[row][col] === 0 || map[row][col] === -1);
}

function L(index) {
  const output = index - 1;
  if (output === 0) return 4;
  return output;
}

function D(index) {
  const output = index + 1;
  if (output === 5) return 1;
  return output;
}

function printMap(map) {
  for (let i = 0; i < map.length; i++) {
    console.log(map[i].join(" "));
  }
}