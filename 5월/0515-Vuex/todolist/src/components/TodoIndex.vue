<template>
    <div>
        <h1 class="underline">TodoList</h1>
        <div v-if="todolist.length">
            <table id="todo-list">
                <colgroup>
                <col style="width: 5%" />
                <col style="width: 30%" />
                <col style="width: 10%" />
                <col style="width: 10%" />
                <col style="width: 10%" />
                <col style="width: 10%" />
                <col style="width: 10%" />
                <col style="width: 10%" />
                </colgroup>
                <thead>
                <tr>
                  
                    <th>번 호</th>
                    <th>할 일</th>
                    <th>작성자</th>
                    <th>시 작</th>
                    <th>종 료</th>
                    <th>실행 여부</th>
                    <th>체크박스</th>
                    <th>수 정</th>
                    <th>삭 제</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(todo, index) in todolist" :key="index">
                    <td>{{index + 1}}</td>
                    <td>{{todo.content}}</td>
                    <td>{{todo.userid}}</td>
                    <td>{{todo.sdate}}</td>
                    <td>{{todo.edate}}</td>
                    <td>{{todo.done}}</td>
                    <td>
                      <input type="checkbox" v-if="todo.done=='Y'" checked @click="doneTodo(todo.no, todo.done)">
                      <input type="checkbox" v-else unchecked @click="doneTodo(todo.no, todo.done)">
                    </td>
                    <router-link :to="`/todomodify/${todo.no}`"><td><button>수 정</button></td></router-link>
                    <td><button @click="deleteOne(todo.no)">삭 제</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    <div v-else class="text-center">내용이 없습니다.</div>
    </div>
</template>

<script>
import http from "@/axios/axios-common.js"
export default {
    name: 'TodoIndex',
    data() {
        return {
          todolist: [],
          no: ""
        };
      },
      created() {
        //서버로 비동기 요청을 해서 데이터 받아오기
        this.selectAll();
      },
      methods: {
        selectAll(){
          http
            .get("/todoLists/allList")
            .then(response => this.todolist = response.data);
        },
        deleteOne(no){
          http
            .delete("/todoLists/" + no)
            .then(() => {
                
              // 등록 성공 메세지 출력
              alert("삭제가 완료되었습니다.");
              this.selectAll();
            });
        },
        doneTodo(no, done){
          http
            .put("/todoLists/done", {
              no,
              done
            })
            .then(()=>{this.selectAll();})
        }
      },
}
</script>

<style scoped>
</style>