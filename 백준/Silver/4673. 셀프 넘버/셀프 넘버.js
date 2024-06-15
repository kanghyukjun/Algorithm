const main = () => {
  const isChecked = new Array(10001).fill(false);
  for (let i = 1; i <= 10000; i++) {
    if (isChecked[i]) continue;
    let current = getNext(i);
    while (current <= 10000) {
      isChecked[current] = true;
      current = getNext(current);
    }
  }

  let output = [];
  for (let i = 1; i <= 10000; i++) {
    if (!isChecked[i]) output.push(i);
  }
  console.log(output.join("\n"));
};

const getNext = (num) => {
  let output = num;
  while (num > 0) {
    output += num % 10;
    num = Math.floor(num / 10);
  }

  return output;
};

main();