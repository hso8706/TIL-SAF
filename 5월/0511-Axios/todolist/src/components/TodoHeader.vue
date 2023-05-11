<template>
    <div class="header">
        <a href="index.html"> <img src="@/assets/logo.png" class="mongsil" /></a>
        <p class="logo">For 몽실이</p>
        
        <router-link to="/"><button>할 일 목록</button></router-link> |
        <router-link to="/todocreate"><button>할 일 생성</button></router-link> |
        <button @click="removeAll">할 일 모두 삭제</button>
    </div>
</template>

<script>
import http from "@/axios/axios-common.js"
export default {
    name: 'TodoHeader',
    methods: {
        removeAll(){
            http
                .delete("/todoLists")
                .then(() => {
                    alert("할 일이 모두 삭제되었습니다.");
                    
                    this.$router.push({path: '/'})
                });
        }
    },
}
</script>

<style scoped>
</style>