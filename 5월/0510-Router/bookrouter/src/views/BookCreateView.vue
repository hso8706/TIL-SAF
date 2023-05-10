<template>
  <div>
    <BookHeader></BookHeader>
    <BookCreate></BookCreate>
    <BookFooter></BookFooter>
  </div>
</template>

<script>
import BookHeader from "../components/BookHeader.vue"
import BookFooter from "../components/BookFooter.vue"
import BookCreate from "../components/BookCreate.vue"
export default {
  components: { BookHeader, BookFooter, BookCreate},

}
</script>

<style>

</style>