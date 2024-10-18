const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
const [T, ...map] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const drow = [1, -1, 0, 0];
const dcol = [0, 0, 1, -1];

const [M, N] = T.split(" ").map(Number);
map.forEach(
  (val, idx, arr) => (arr[idx] = [-1, ...val.trim().split("").map(Number)])
);
map.unshift(Array.from({ length: M + 1 }, () => -1));

que = [{ x: 1, y: 1, broke: 0 }];
const brokeCount = Array.from({ length: N + 1 }, () =>
  Array.from({ length: M + 1 }, () => Infinity)
);

while (que.length) {
  const { x, y, broke } = que.shift();
  if (brokeCount[x][y] < broke) continue;

  for (let i = 0; i < 4; i++) {
    const nRow = x + drow[i];
    const nCol = y + dcol[i];
    if (isValid(nRow, nCol)) {
      if (map[nRow][nCol] === 0) {
        if (brokeCount[nRow][nCol] > broke) {
          brokeCount[nRow][nCol] = broke;
          que.push({ x: nRow, y: nCol, broke });
        }
      } else {
        if (brokeCount[nRow][nCol] > broke + 1) {
          brokeCount[nRow][nCol] = broke + 1;
          que.push({ x: nRow, y: nCol, broke: broke + 1 });
        }
      }
    }
  }
}

console.log(brokeCount[N][M] === Infinity ? 0 : brokeCount[N][M]);

function isValid(x, y) {
  return 1 <= x && x <= N && 1 <= y && y <= M;
}