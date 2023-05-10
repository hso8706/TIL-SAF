<template>
  <div>
    <BookHeader></BookHeader>
    <BookIndex></BookIndex>
    <BookFooter></BookFooter>
  </div>
</template>

<script>
// @ is an alias to /src
import BookIndex from '@/components/BookIndex.vue'
import BookHeader from '@/components/BookHeader.vue'
import BookFooter from '@/components/BookFooter.vue'

export default {
  name: 'HomeView',
  components: {
    BookHeader, BookIndex, BookFooter
  }
}
</script>
