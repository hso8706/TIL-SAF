<template>
    <div class="regist">
        <h1 class="underline">SSAFY 도서 등록</h1>
        <div class="regist_form">
          <label for="isbn">도서번호</label>
          <input type="text" id="isbn" name="isbn" v-model="isbn" ref="isbn" /><br />

          <label for="title">도서명</label>
          <input type="text" id="title" name="title" v-model="title" ref="title" /><br />

          <label for="author">저자</label>
          <input type="text" id="author" name="author" v-model="author" ref="author" /><br />

          <label for="price">가격</label>
          <input type="number" id="price" name="price" v-model="price" ref="price" /><br />

          <label for="content">설명</label><br />
          <textarea id="content" name="content" v-model="content" ref="content" cols="35" rows="5"></textarea><br />
          
          <button @click="registBook">등록</button>
          <button @click="moveList">목록</button>
        </div>
      </div>
</template>

<script>
export default {
    name: 'BookIndex',
    data() {
        return {
          //v-model로 이어줄 데이터
          isbn: "",
          title: "",
          author: "",
          price: "",
          content: ""
        };
      },
      methods: {
        //click event1
        registBook() {
          // // 화면 입력된 데이터를 saveBook에 추가
          // let newBook = {
          //   isbn: this.isbn,
          //   title: this.title,
          //   author: this.author,
          //   price: this.price,
          //   content: this.content
          // };
          // 로컬스토리지에 저장된 데이터 가져오기
          const booklist = localStorage.getItem("booklist");

          // 데이터 선언
          let saveBook = [];

          // 기존 로컬스토리지에 저장된 내용이 있다면 문자열 형식의 booklist를 json 객체로 변경(로컬스토리지에는 문자열로만 저장할 수 있음)
          if (booklist) {
            saveBook = JSON.parse(booklist); //string -> json
            
          }else { //기존 데이터가 없는 경우-나중에 꺼내서 써야 하니까 
          localStorage.setItem("booklist", JSON.stringify(saveBook)); //json -> string
            }

          // 화면 입력된 데이터를 saveBook에 추가
          saveBook.push({
            isbn: this.isbn,
            title: this.title,
            author: this.author,
            price: this.price,
            content: this.content
          });
          // 로컬스트리지 저장
          localStorage.setItem("booklist", JSON.stringify(saveBook));
          
          // 등록 성공 메세지 출력
          alert("등록이 완료되었습니다.");
          // 목록 페이지로 이동하기
          location.href = "./list.html";
        },
        
        moveList() {
          location.href = "list.html";
        }
      }
}
</script>

<style scoped>
</style>