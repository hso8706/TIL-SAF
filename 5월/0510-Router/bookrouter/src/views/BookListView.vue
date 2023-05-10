<template>
  <div>
    <BookHeader></BookHeader>
    <BookList></BookList>
    <BookFooter></BookFooter>
  </div>
</template>

<script>
import BookList from "../components/BookList.vue"
import BookHeader from "../components/BookHeader.vue"
import BookFooter from "../components/BookFooter.vue"
export default {
  components: { BookList, BookHeader, BookFooter},

}
</script>

<style>

</style>