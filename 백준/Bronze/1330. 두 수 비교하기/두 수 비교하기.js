const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./util/input.txt";
let [N, M] = fs.readFileSync(filePath, "utf-8").trim().split(" ").map(Number);

if(N < M) {
    console.log("<")
} else if(N > M) {
    console.log(">")
} else {
    console.log("==")
}
