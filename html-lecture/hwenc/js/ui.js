// js는 인터프리팅 언어이다.
// 컴파일 과정을 거치지 않는다.
// alert("hello javascript");
// 객체.함수() > 객체에 따라서 함수의 역할이 달라진다.
// (ex) 강아지.먹다()
//      사람.먹다()
// 객체.함수() → 함수 → 함수는 항상 결과가 있음
// 객체.속성 -> 속성

// console.log("hello world"); //메서드
// console.log(99 * 12);

//클래스 찾기 → 함수는 항상 결과값이 존재함
const gnb = document.querySelector(".gnb > ul");
const header = document.querySelector(".header");
console.log("🚀 ~ file: ui.js:16 ~ header:", header); //ctrl+alt+l
const btnClose = document.querySelector(".popup .btns .close");
const popup = document.querySelector(".popup");

// 콜백 함수 > 정의(선언)만 존재하고 호출이 없음
// 사용자가 동작했을 때 호출됨 > 동작 : 마우스 올리기
gnb.addEventListener("mouseenter", function () {
  console.log("gnb에 마우스 올라온 것을 체크(감지)할 수 있다.");
  header.classList.add("open");
});

// 콜백 함수 > 정의(선언)만 존재하고 호출이 없음
// 사용자가 동작했을 때 호출됨 > 동작 : 마우스 떼기
gnb.addEventListener("mouseleave", function () {
  console.log("gnb에 마우스 뗄어진 것을 체크(감지)할 수 있다.");
  header.classList.remove("open");
});

// // 콜백 함수 > 정의(선언)만 존재하고 호출이 없음
// // 사용자가 동작했을 때 호출됨 > 동작 : 팝업창 닫기 클릭
// btnClose.addEventListener("click", function () {
//   console.log("popup창 닫기");
//   popup.classList.add("hidden");
// });

// // 콜백 함수 > 정의(선언)만 존재하고 호출이 없음
// // 사용자가 동작했을 때 호출됨 > 동작 : 팝업창 닫기 클릭
// btnClose[0].addEventListener("click", function () { // btnClose[0] →querySelectorAll 일 때만 가능하다
//   console.log("popup창 닫기");
//   popup.classList.add("hidden");
// });

// dom 안에 있는 애들은 찾아야하는데
// window or 다큐먼트는 안찾아도 됨
// window.addEventListener("scroll" 함수명()); > 함수 죽음
// window.addEventListener("scroll" 함수명); > 함수 살음

let oldY = window.scrollY;

// 사용자가 동작했을 때 호출됨 > 동작 : 스크롤 움직이면 메뉴바 내려오기
window.addEventListener("scroll", function () {
  console.log(window.scrollY);
  // 조건문
  if (window.scrollY > 0) {
    header.classList.add("scroll");
    if (window.scrollY - oldY > 0) {
      header.classList.add("down");
    } else {
      header.classList.remove("down");
    }
  } else {
    header.classList.remove("scroll");
  }
  oldY = window.scrollY;
});

new Swiper(".social .banner", {
  slidesPerView: 4, //auto로 하면 안됨
  spaceBetween: 10,
  loop: true,

  // 스와이퍼 > 네비게이션
  navigation: {
    prevEl: ".social .btn-prev",
    nextEl: ".social .btn-next",
  },

  // 스와이퍼 > 페이지네이션
  pagination: {
    el: ".social .pagination",
    type: "progressbar",
  },
});
