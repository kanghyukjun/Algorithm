function main() {
  // get input
  const input = require("fs").readFileSync(0, 'utf-8').toString().split("\n");
  const nums = input[0].split(" ");
  const N = parseInt(nums[0]);

  // process
  const set = new Set();
  for (let i = 1; i <= N; i++) {
    const string = input[i];
    set.add(string);
  }

  let count = 0;
  for (let i = N + 1; i < input.length; i++) {
    const string = input[i];
    if (set.has(string)) count++;
  }

  // output
  console.log(count);
}

main();