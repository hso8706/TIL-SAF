<template>
    <div class="regist">
        <h1 class="underline">SSAFY 도서 정보</h1>
        <div class="regist_form">
          <label for="isbn">도서번호</label>
            <div class="view">{{book.isbn}}</div>
            <label for="title">도서명</label>
            <div class="view">{{book.title}}</div>
            <label for="author">저자</label>
            <div class="view">{{book.author}}</div>
            <label for="price">가격</label>
            <div class="view">{{numberWithCommas(book.price)}}원</div>
            <label for="content">설명</label>
            <div class="view" v-html="enterToBr(book.content)"></div>
            <div style="padding-top: 15px">
                <!-- <a href="./list.html" class="btn">목록</a> -->
                <router-link to="/booklist"><button>목록</button></router-link>
                <router-link :to="`/bookdelete/${book.isbn}`"><button>삭제</button></router-link>
                
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'BookIndex',
    data: function () {
        return {
          book: {}
        };
      },
    created() {
        // url에서 파라미터정보 얻기.
        // const params = new URL(document.location).searchParams; // no router
        const isbn = this.$route.params.isbn;
        // localStorage에서 booklist로 저장된 도서 목록을 얻어온 후 JSON객체로 parsing한다.
        const booklist = JSON.parse(localStorage.getItem("booklist"));

        for (let book of booklist) {
          // 보여줄 isbn을 찾았다면.
          // if (params.get("isbn") == book.isbn) {
          if (isbn == book.isbn) {
            // 전역변수 book에 화면에 보여줄 객체를 저장.
            this.book = book;
            break;
          }
        }
      },
      methods: {
        numberWithCommas(x) {
          return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        },
        enterToBr(str) {
          // 문자열에 enter값을 <br />로 변경.(html상에서 줄바꿈 처리)
          return str.replace(/(?:\r\n|\r|\n)/g, "<br />");
        }
      }
}
</script>

<style scoped>
</style>