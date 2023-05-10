<template>
  <div>
    <BookHeader></BookHeader>
    <BookDelete></BookDelete>
    <BookFooter></BookFooter>
  </div>
</template>

<script>
import BookDelete from "../components/BookDelete.vue"
import BookHeader from "../components/BookHeader.vue"
import BookFooter from "../components/BookFooter.vue"
export default {
  components: { BookDelete, BookHeader, BookFooter},

}
</script>

<style>

</style>