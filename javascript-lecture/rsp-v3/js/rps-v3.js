// 가위바위보 게임
// 컴퓨터(자동선택) vs 유저(수동선택)

// 요소 찾기
// 요소 찾기 > 컴퓨터(array) > querySelectorAll
const computerList = document.querySelectorAll(".computer li");
// 요소 찾기 > 유저(array) > querySelectorAll
const humanList = document.querySelectorAll(".human li");
// 요소 찾기 > 결과(값이 1개) > querySelector
const result = document.querySelectorAll(".result");

// ???
let random; // 전역변수 선언

// 선택 > 컴퓨터(랜덤:0~2)
function computerRandomchoice() {
  // [선택 전] 숨기기
  computerList[0].style.display = "none";
  computerList[1].style.display = "none";
  computerList[2].style.display = "none";

  // [선택 값] 랜덤(0~2)
  random = Math.floor(Math.random() * 3);

  // [선택 후] 보여주기
  computerList[random].style.display = "block";
}

// [선택 전] 특정 시간동안 computerRandomchoice함수를 200ms만큼 반복
const idx = setInterval(computerRandomchoice, 20);

// 선택 > 유저(직접:0~2)
for (let i = 0; i < 3; i++) {
  humanList[i].addEventListener("click", function () {
    const humanChoice = i;
    const selectNum = random;

    clearInterval(idx);

    if (humanChoice === selectNum) {
      result.textContent = "👍draw👍";
    } else if (humanChoice === 0 && selectNum === 1) {
      result.textContent = "🍀lose🍀";
    } else if (humanChoice === 1 && selectNum === 2) {
      result.textContent = "🍀lose🍀";
    } else if (humanChoice === 2 && selectNum === 0) {
      result.textContent = "🍀lose🍀";
    } else {
      result.textContent = "🥇win🥇";
    }
  });
}
