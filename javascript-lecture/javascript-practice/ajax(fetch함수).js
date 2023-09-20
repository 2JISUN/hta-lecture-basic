// 외부 api 가져오기

const result = fetch(
  // fetch : 비동기 함수
  "https://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api?serviceKey=jwMW2GOSieJWT6qS71g3NHVl%2FLmojUpBM0HoTAbGSSCTjxXNuMbKlS3ENQHnCtfGpLzu5L6TUrDhuzLKbpMzsA%3D%3D&pageNo=1&numOfRows=500&apiType=JSON&std_day=2023-08-07"
)
  .then(function (response) {
    return response.json(); //promise 로 리턴됨 -> then으로 결과를 받아볼 수 있음
  })
  .then(function (result) {
    console.log(result.items[0].incDec);
    result.items.forEach(function (item) {
      console.log(item.gubun + ":" + item.incDec);
    });
  });
