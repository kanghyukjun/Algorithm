const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [size, position, ...map] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const drow = [-1, 0, 1, 0];
const dcol = [0, 1, 0, -1];

const [N, M] = size.split(" ").map(Number);
let [row, col, dir] = position.split(" ").map(Number);
map.forEach((row, idx, arr) => {
  arr[idx] = row.split(" ").map(Number);
});

// 1 -> 벽, 0 -> 청소되지 않은 칸, -1 -> 청소된 칸
let count = 0;

while (true) {
  if (map[row][col] === 0) {
    count++;
    map[row][col] = -1;
  }

  let flag = false;
  for (let i = 0; i < 4; i++) {
    const [nRow, nCol] = [row + drow[i], col + dcol[i]];
    if (!isValid(nRow, nCol)) {
      continue;
    }
    if (map[nRow][nCol] === 0) {
      flag = true;
      break;
    }
  }

  // 청소되지 않은 칸이 있는 경우
  if (flag) {
    dir = (dir + 3) % 4;
    const [nRow, nCol] = [row + drow[dir], col + dcol[dir]];
    if (isValid(nRow, nCol) && map[nRow][nCol] === 0) {
      row = nRow;
      col = nCol;
    }
  }
  // 청소되지 않은 칸이 없는 경우
  else {
    const backDir = (dir + 2) % 4;
    const [nRow, nCol] = [row + drow[backDir], col + dcol[backDir]];
    if (isValid(nRow, nCol) && map[nRow][nCol] !== 1) {
      row = nRow;
      col = nCol;
    } else {
      break;
    }
  }
}
console.log(count);

function isValid(nRow, nCol) {
  return 0 <= nRow && nRow < N && 0 <= nCol && nCol < M;
}