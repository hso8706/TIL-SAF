/*
 export default
 - 해당 js 파일을 다른 곳에서 import 할 수 있게 만드는 키워드
 - default 지정은 한 번 밖에 허용못함, 이름을 명시하는 경우에는 하나의 .js파일에서 여러 개 가능
 - 현재 이름이 없이 export 시켰기 때문에 필요한 곳. 즉, import하는 곳에서 이름을 명시
 */
export default {
    //화면을 나타내는 속성, 백틱을 사용하면 문단 그대로 자연스럽게 쓸 수 있음
    template: `
    <div class="header">
        <a href="index.html"> <img src="./img/ssafy_logo.png" class="ssafy_logo" /></a>
        <p class="logo">도서관리</p>
    </div>
    `
}