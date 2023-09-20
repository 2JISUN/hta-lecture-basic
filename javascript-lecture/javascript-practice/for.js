//while, for
let i = 0;

while (i < 10) {
  console.log("나는 조건을 만족하면 실행됩니다.");
  i++;
}
console.log("끝");

// for + if
for (let j = 1; j < 100; j++) {
  // 3의 배수만 빼기...
  if (j % 3 === 0) {
    // break; // 조건을 만나면 멈추기
    // continue; // 조건을 만나면 건너뛰기
  } else {
    console.log(j);
  }
}

// 3의 배수의 합을 구하기
let sum = 0;
for (let j = 1; j < 100; j++) {
  if (j % 3 === 0) {
    sum = sum + j;
  }
}
console.log(sum);

// 구구단
for (let i = 2; i < 10; i++) {
  for (let j = 1; j < 10; j++) {
    console.log(`${i} X ${j} = ${i * j}`); //js 백틱
  }
}
