<template>
  <div>
    <TodoHeader></TodoHeader>
    <TodoCreate></TodoCreate>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from "../components/TodoHeader.vue"
import TodoFooter from "../components/TodoFooter.vue"
import TodoCreate from "../components/TodoCreate.vue"
export default {
  components: { TodoHeader, TodoFooter, TodoCreate},

}
</script>

<style>

</style>