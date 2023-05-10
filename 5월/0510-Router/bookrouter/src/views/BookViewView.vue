<template>
  <div>
    <BookHeader></BookHeader>
    <BookView></BookView>
    <BookFooter></BookFooter>
  </div>
</template>

<script>
import BookView from "../components/BookView.vue"
import BookHeader from "../components/BookHeader.vue"
import BookFooter from "../components/BookFooter.vue"
export default {
  name: "BookViewView",
  components: { BookView, BookHeader, BookFooter},

}
</script>

<style>

</style>