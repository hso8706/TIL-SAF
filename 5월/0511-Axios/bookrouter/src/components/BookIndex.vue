<template>
    <div>
        <ul>
            <router-link to="/bookcreate"><li>도서 등록</li></router-link>
            <router-link to="/booklist"><li>도서 목록</li></router-link>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'BookIndex',
}
</script>

<style scoped>
</style>