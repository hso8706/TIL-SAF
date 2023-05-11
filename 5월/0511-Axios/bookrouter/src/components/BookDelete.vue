<template>
  <div>
    <h1>후회하시지 않으시겠습니까??</h1>
    <button @click="removeBook">예</button>
    <router-link to="/booklist"><button>아니오</button></router-link>
  </div>
</template>

<script>
import http from "@/axios/axios-common.js"
export default {
  name: 'BookDelete',
  methods: {
    removeBook() {
      const isbn = this.$route.params.isbn;

      http
          .delete("/book/"+isbn)
          .then(() => {
              // 등록 성공 메세지 출력
              alert("삭제가 완료되었습니다.");
              // 목록 페이지로 이동하기
              this.$router.push({path: `/booklist`})
              });
    },
  }
}
</script>

<style>

</style>