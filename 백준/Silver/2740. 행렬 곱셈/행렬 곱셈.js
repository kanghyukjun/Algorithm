const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
const [...inputs] = fs.readFileSync(filePath, "utf-8").trim().split("\n");

const A = [];
const [N, M] = inputs[0].split(" ").map(Number);
for (let i = 1; i <= N; i++) {
  A[i - 1] = inputs[i].split(" ").map(Number);
}

const B = [];
const [, K] = inputs[N + 1].split(" ").map(Number);
for (let i = N + 2; i < inputs.length; i++) {
  B[i - N - 2] = inputs[i].split(" ").map(Number);
}
const mat = matMultiply(A, B);
let result = "";
mat.forEach((x) => (result += x.join(" ") + "\n"));
console.log(result);

function matMultiply(A, B) {
  const N = A.length;
  const M = B.length;
  const K = B[0].length;
  const result = Array.from({ length: N }, () => new Array(K).fill(0));
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < K; j++) {
      for (let k = 0; k < M; k++) {
        result[i][j] += A[i][k] * B[k][j];
      }
    }
  }
  return result;
}