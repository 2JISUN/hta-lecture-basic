// t/f 를 구별하는게 중요함
// falsy => 0, undefined, null, "", NaN 등등

// test
if (2 - 2) {
  console.log("조건이 t면 출력합니다");
} else {
  console.log("조건이 f면 출력합니다");
}

// 성적
let score = 50;
if (score >= 90) {
  console.log("A");
} else if (score >= 80) {
  console.log("B");
} else if (score >= 70) {
  console.log("C");
} else if (score >= 60) {
  console.log("D");
} else {
  console.log("F");
}

// 비만율 (bmi 지수)
let height = 162; //cm
let weight = 55; //kg
let meterHeight = height / 100; //cm -> m
let result = weight / meterHeight ** 2;
console.log(result);

if (result >= 25) {
  console.log("비만");
} else if (result < 18) {
  console.log("저체중");
} else {
  console.log("정상");
}
