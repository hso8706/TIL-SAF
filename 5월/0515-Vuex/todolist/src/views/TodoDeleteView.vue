<template>
  <div>
    <TodoHeader></TodoHeader>
    <TodoDelete></TodoDelete>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from "@/components/TodoHeader.vue"
import TodoFooter from "@/components/TodoFooter.vue"
import TodoDelete from "@/components/TodoDelete.vue"
export default {
  components: { TodoHeader, TodoFooter, TodoDelete},

}
</script>

<style>

</style>