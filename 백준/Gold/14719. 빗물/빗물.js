const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [nums, inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const [H, W] = nums.split(" ").map(Number);
inputs = inputs.split(" ").map(Number);
const map = Array.from({ length: H }, () => new Array(W).fill(false));
inputs.forEach((value, idx) => {
  for (let i = 0; i < value; i++) {
    map[H - i - 1][idx] = true;
  }
});

let output = 0;
for (let height = 0; height < H; height++) {
  const row = H - height - 1;

  // 1. 왼쪽에서 오른쪽으로 이동하면서, true를 처음 만난다면 그 이후부터 이동한 갯수를 기록한다
  // 2. 이동하면서 또 한번 true를 만났다면 지금까지 저장한 갯수를 전역 변수에 저장하고, 저장한 갯수를 초기화 한다
  // 3. true를 끝까지 만나지 못했다면 저장한 갯수를 초기화한다
  // 4. 최종 전역 변수에 저장된 값을 출력한다.
  let isCountable = false;
  let count = 0;
  for (let col = 0; col < W; col++) {
    if (map[row][col]) {
      isCountable = true;
    }

    if (!map[row][col] && isCountable) {
      count++;
    }

    if (map[row][col] && isCountable) {
      output += count;
      count = 0;
    }
  }
}
console.log(output);