<template>
  <div>
    <TodoHeader></TodoHeader>
    <TodoModify></TodoModify>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
// @ is an alias to /src
import TodoModify from '@/components/TodoModify.vue'
import TodoHeader from '@/components/TodoHeader.vue'
import TodoFooter from '@/components/TodoFooter.vue'

export default {
  components: {
    TodoHeader, TodoModify, TodoFooter
  }
}
</script>
