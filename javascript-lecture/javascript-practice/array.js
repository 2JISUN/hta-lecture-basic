/*
배열(나열)
- 순서없는 것들에게 순서 매기기
*/

let myClass = ["이마크", "황런쥔", "이제노"];
console.log(myClass[0] === "이마크");
console.log(myClass[0] === "황런쥔");
console.log(myClass[0] === "이제노");

const current = new Date();
console.log(current);
console.log(current.getDay());
const yoil = current.getDay();
const yoilArray = ["일", "월", "화", "수", "목", "금", "토"];
yoilArray.push("back"); // .push(데이터) > 배열에 데이터 뒤로 추가 ()
// yoilArray.unshift("front"); // .front(데이터) > 배열에 데이터 앞으로 추가 () / 사용을 지양함
console.log(yoilArray[yoil]);

// 모든 프로그래밍 언어에는 문(statement) > 조건문, 반복문
//			  식(expression) > 값을 반환 > const num = 10 + 5;

// 반복문
for (let i = 0; i < 8; i++) {
  console.log(yoilArray[i]);
}

// 조건문
if (yoil === 1) {
  console.log("월요일");
} else if (yoil === 2) {
  console.log("월요일이 아님");
}

/* 배열 복사*/
// 배열 기준
let animals = ["panda", "puppy", "kitty", "tiger"]; // basic
let copyAnimals = animals; // basic 복사 (값이 할당된 메모리를 참조함)
let copyAnimals2 = [...animals, "chicken"]; // basic != 새로운 배열

// 배열 하나씩 출력
console.log(copyAnimals[0]);
console.log(copyAnimals[1]);

// 배열 전체 출력 (1. 반복문)
for (let i = 0; i < copyAnimals.length; i++) {
  console.log(animals[i]);
}

// 배열 전체 출력 (2. js메소드)
animals.forEach(function (item, index) {
  console.log(index, ":", item);
});

// 배열 전체 출력 (3. spread operator)
console.log(...animals);
console.log(...copyAnimals);
console.log(...copyAnimals2);
