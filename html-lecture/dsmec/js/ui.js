// 연동 > js > 내부 라이브러리 > 이벤트
// 메뉴바 오픈 시 이벤트 발생

//클래스 찾기 → 함수는 항상 결과값이 존재함
const gnb = document.querySelector(".gnb > ul"); // 메뉴바 전체 찾기
const header = document.querySelector(".header"); // 헤더 전체 찾기
// vscode extention
console.log("🚀 ~ file: ui.js:16 ~ header:", header); //ctrl+alt+l
const popup = document.querySelector(".popup"); // 팝업창 전체 찾기
const btnClose = document.querySelector(".popup .btns .close"); // 팝업창 닫기 찾기

// 콜백 함수 > 정의(선언)만 존재하고 호출이 없음
// but 사용자가 동작했을 때 호출됨 > 동작 : 마우스 올리기
// .gnb > .open 과 같다
gnb.addEventListener("mouseenter", function () {
  console.log("gnb에 마우스 올라온 것을 체크(감지)할 수 있다.");
  // html 문서에는 존재하지 않는 태그지만 이벤트를 만듦으로써 scss에서 클래스로 접근할 수 있다
  header.classList.add("open");
});

// 콜백 함수 > 정의(선언)만 존재하고 호출이 없음
// but 사용자가 동작했을 때 호출됨 > 동작 : 마우스 떼기
// .gnb > .open 과 같다
gnb.addEventListener("mouseleave", function () {
  console.log("gnb에 마우스 뗄어진 것을 체크(감지)할 수 있다.");
  // html 문서에는 존재하지 않는 태그지만 이벤트를 만듦으로써 scss에서 클래스로 접근할 수 있다
  header.classList.remove("open");
});
