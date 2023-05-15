<template>
  <div>
    <TodoHeader></TodoHeader>
    <TodoIndex></TodoIndex>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
// @ is an alias to /src
import TodoIndex from '@/components/TodoIndex.vue'
import TodoHeader from '@/components/TodoHeader.vue'
import TodoFooter from '@/components/TodoFooter.vue'

export default {
  components: {
    TodoHeader, TodoIndex, TodoFooter
    // TodoIndex, TodoFooter
  }
}
</script>
