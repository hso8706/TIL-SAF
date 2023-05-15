<template>
    <div class="regist">
        <h1 class="underline">할 일 등록</h1>
        <div class="regist_form">
          <label for="content">할 일</label>
          <input type="text" id="content" name="content" v-model="content" ref="content" /><br />

          <label for="userid">작성자</label>
          <input type="text" id="userid" name="userid" v-model="userid" ref="userid" /><br />

          <label for="sdate">시작일</label>
          <input type="date" id="sdate" name="sdate" v-model="sdate" ref="sdate" /><br />

          <label for="edate">종료일</label>
          <input type="date" id="edate" name="edate" v-model="edate" ref="edate" /><br />
          
          <button @click="registTodo">등록</button>
          <button @click="moveList">목록</button>
        </div>
      </div>
</template>

<script>
import http from "@/axios/axios-common.js"
export default {
    name: 'TodoCreate',
    data() {
        return {
          //v-model로 이어줄 데이터
          content: "",
          userid: "",
          sdate: "",
          edate: ""
        };
      },
      methods: {
        registTodo() {
          http
            .post("/todoLists", {
              content: this.content,
              userid: this.userid,
              sdate: this.sdate,
              edate: this.edate
            })
            .then(() => {
              // 등록 성공 메세지 출력
              alert("등록이 완료되었습니다.");
              // 목록 페이지로 이동하기
              this.$router.push({path: `/`});
            });

          
        },
        
        moveList() {
          this.$router.push({path: `/`});
        }
      }
}
</script>

<style scoped>
</style>