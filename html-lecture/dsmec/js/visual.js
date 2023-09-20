// 연동 > js > 외부 라이브러리 > 이벤트
// 스와이퍼 > 페이지네이션, 네비게이션
// 스플리팅 > 글자 분할
// gsap > 애니메이션
// 스플리팅 + gsap => 글자 하나씩 나타나기 ui를 만들 수 있다

// 스플리팅 > 글자 분할
Splitting();

// 스와이퍼 함수로 묶기
// prettier-ignore
const swiper = new Swiper(".main-visual", {
                                           // 스와이퍼 효과
                                            effect: "fade", // 슬라이드
                                            loop: true, // 무한반복
                                            autoplay: { // 자동재생
                                                        delay: 3000, 
                                                        disableOnInteraction: false, // 페이지네이션 클릭해도 자동재생 가능
                                                      },
                                            speed: 1000,

                                          // 스와이퍼 페이지네이션
                                          pagination: {
                                                        el: ".main-visual .pagination",
                                                        type: "bullets",
                                                        clickable: true, //요소 클릭 시 해당 페이지로 이동
                                                      },

                                          // 스와이퍼 네비게이션
                                          navigation: {
                                                        prevEl: ".main-visual .btn-prev",
                                                        nextEl: ".main-visual .btn-next",
                                                      },

                                          // 스와이퍼 이벤트 > 슬라이드가 처음으로 돌아올 때 발생
                                          //                > 이벤트는 코드 작성 순서와 무관함
                                              on: {
                                                    // 끝
                                                    slideChangeTransitionEnd: function () {
                                                      console.log(this.realIndex);
                                                      // 글자 분할 > 효과 주기
                                                      gsap.to(".swiper-slide-active .char", { y: 0, opacity: 1, stagger: 0.05 });
                                                    },

                                                    // 시작+1
                                                    slideChangeTransitionStart: function () {
                                                      console.log(this.realIndex);
                                                      // 글자 분할 > 효과 주기
                                                      gsap.set(".swiper-slide-active .char", { y: 100, opacity: 0 });
                                                    },

                                                    // 시작
                                                    init: function () {
                                                      gsap.from(".swiper-slide-active .char", { y: 100, opacity: 0, stagger: 0.05 });
                                                    },
                                                 },
});
