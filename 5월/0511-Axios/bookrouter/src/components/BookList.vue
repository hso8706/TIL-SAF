<template>
    <div>
        <h1 class="underline">도서 목록</h1>
        <div style="text-align: right">
            <button @click="movePage">도서 등록</button>
        </div>
        <div v-if="booklist.length">
            <table id="book-list">
                <colgroup>
                <col style="width: 5%" />
                <col style="width: 20%" />
                <col style="width: 40%" />
                <col style="width: 20%" />
                <col style="width: 15%" />
                </colgroup>
                <thead>
                <tr>
                    <th>번호</th>
                    <th>ISBN</th>
                    <th>제목</th>
                    <th>저자</th>
                    <th>가격</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(book, index) in booklist" :key="index">
                    <td>{{index + 1}}</td>
                    <td>{{book.isbn}}</td>
                    <td>
                    <!-- <a :href="'view.html?isbn=' + book.isbn">{{book.title}}</a> -->
                      <router-link :to="`/bookview/${book.isbn}`">{{book.title}}</router-link>
                    </td>
                    <td>{{book.author}}</td>
                    <td>{{book.price}}원</td>
                </tr>
                </tbody>
            </table>
        </div>
    <div v-else class="text-center">내용이 없습니다.</div>
    </div>
</template>

<script>
// import axios from "axios";
import http from "@/axios/axios-common.js"
export default {
    name: 'BookIndex',
    data() {
        return {
          // 도서목록을 저장할 배열
          booklist: [],
        };
      },
      created() {
        //서버로 비동기 요청을 해서 데이터 받아오기
        this.selectAll();
      },
      methods: {
        selectAll(){
          // axios
          //   .get('http://localhost/book')
          //   .then(response => this.booklist = response.data);
          http
            .get("/book")
            .then(response => this.booklist = response.data);
        },
        movePage() {
          // location.href = "create.html";
          this.$router.push({path: '/bookcreate'})
        },
      },
}
</script>

<style >

</style>