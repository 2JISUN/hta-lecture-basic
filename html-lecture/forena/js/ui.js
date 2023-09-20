// js는  인터프리팅 언어이다. 컴파일 과정을 거치지 않는다.
//alert("hello javascript");
//console.log("hello world"); //메서드
//console.log(19090 + 48934);
const gnb = document.querySelector(".gnb > ul");
const header = document.querySelector(".header");
const btnClose = document.querySelector(".popup .btns .close");
console.log("🚀 ~ file: ui.js:8 ~ btnClose:", btnClose);
const popup = document.querySelector(".popup");

gnb.addEventListener("mouseenter", function () {
  console.log("gnb에 마우스 올라온걸 체크(감지)할 수 있다.");
  header.classList.add("open");
});
gnb.addEventListener("mouseleave", function () {
  console.log("gnb에 마우스 올라온걸 체크(감지)할 수 있다.");
  header.classList.remove("open");
});
btnClose.addEventListener("click", function () {
  //console.log("click");
  popup.classList.add("hidden");
});

// function aa() {
//   console.log("때때때때");
// }

let oldY = window.scrollY;
window.addEventListener("scroll", function (e) {
  //console.log(window.scrollY);
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
  slidesPerView: 5,
  spaceBetween: 10,
  loop: true,
  navigation: {
    prevEl: ".social .btn-prev",
    nextEl: ".social .btn-next",
  },
  pagination: {
    el: ".social .pagination",
    type: "progressbar",
  },
  //centeredSlides: true,
});

// 섹션별 스크롤 이동
window.onload = function () {
  const elm = document.querySelectorAll(".section");
  const elmCount = elm.length;
  elm.forEach(function (item, index) {
    item.addEventListener("mousewheel", function (event) {
      event.preventDefault();
      let delta = 0;

      if (!event) event = window.event;
      if (event.wheelDelta) {
        delta = event.wheelDelta / 120;
        if (window.opera) delta = -delta;
      } else if (event.detail) delta = -event.detail / 3;

      let moveTop = window.scrollY;
      let elmSelector = elm[index];

      // wheel down : move to next section
      if (delta < 0) {
        if (elmSelector !== elmCount - 1) {
          try {
            moveTop = window.pageYOffset + elmSelector.nextElementSibling.getBoundingClientRect().top;
          } catch (e) {}
        }
      }
      // wheel up : move to previous section
      else {
        if (elmSelector !== 0) {
          try {
            moveTop = window.pageYOffset + elmSelector.previousElementSibling.getBoundingClientRect().top;
          } catch (e) {}
        }
      }

      const body = document.querySelector("html");
      window.scrollTo({ top: moveTop, left: 0, behavior: "smooth" });
    });
  });
};
