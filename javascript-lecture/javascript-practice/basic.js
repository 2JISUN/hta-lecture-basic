// console.log("hello js");
// 컴파일러 ... 인터프리터..
// javascript는 html에 종속되어있었지만 node js를 통해 독립적인(단독) 확장자로써 사용할 수 있다
// 중요한 의미를 갖는 이유는? js가 웹을 벗어나 다른 응용프로그램을 만들 수 있다!! (대박)
// js 는 type이 정해져 있지 않다
// var / let const
// 변수

// var은 {유효범위}를 벗어나도 가능 > 최근 거의 사용 X
// let은 {유효범위}를 벗어나도 가능 > 중복선언 불가능
// 변수 선언할 때는 웬만하면 let을 쓰자~

// falsy => 0, undefined, null, "", NaN 등등

let myName = "이지선";
let myAge = 27;
const pi = 3.14; // 상수
myAge = myAge + 1; // "=" 할당 연산자

// console.log(myAge == 28); // true
// console.log(myAge == "28"); // true
// console.log(myAge === "28"); // false

let isMarried = 0 / 0; // boolean => true(0을 제외한 나머지 숫자) or false(0)
let myWeight = null; // 아무것도 없다 > false
let test = 10;
console.log(myWeight);
console.log(typeof myWeight);
console.log(test);
console.log(typeof test);

// if (isMarried) {
//   console.log("기혼");
// } else {
//   console.log("미혼");
// }
