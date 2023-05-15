<template>
    <div>
        <h1>정말로 모든 todo-list를 삭제하시겠습니까?</h1>
        <button @click="removeAll">예</button>  |  <router-link to="/"><button>아니오</button></router-link>
    </div>
    
</template>

<script>
    import http from "@/axios/axios-common.js"
    export default {
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

<style>

</style>