<template>
    <div class="header">
        <div>
          <a href="index.html"> <img src="@/assets/logo.png" class="mongsil" /></a>
          <p class="logo">For 몽실이</p>
          
          <router-link to="/"><button>할 일 목록</button></router-link> |
          <router-link to="/todocreate"><button>할 일 생성</button></router-link> |
          <router-link to="/tododelete"><button>할 일 모두 삭제</button></router-link>
        </div>
    </div>
</template>

<script>
export default {
    name: 'TodoHeader'
}
</script>

<style scoped>
</style>