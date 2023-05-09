<template>
    <h1>Myworld.vue 입니다.{{code}}</h1>
</template>

<script>
export default {
    name: 'MyWorld',
    props: ["code"]
}
</script>

<!-- scoped : 해당 component에만 적용하기 위한 속성 -->
<style scoped>
    h1{
        color: rgb(241, 69, 126);
        font-size: 30pt;
        /* font-family: 궁서체; */
    }
</style>