<template>
  <div>
    <h1>후회하시지 않으시겠습니까??</h1>
    <button @click="removeBook">예</button>
    <router-link to="/booklist"><button>아니오</button></router-link>
  </div>
</template>

<script>
export default {
  name: 'BookDelete',
  methods: {
    removeBook() {
      const isbn = this.$route.params.isbn;

      const booklist = localStorage.getItem("booklist");

      let reBook = [];

      if (booklist) {
        reBook = JSON.parse(booklist);
      }
      
      for (let index = 0; index < reBook.length; index++) {
        if (reBook[index].isbn == isbn) {
          reBook.splice(index, 1);
          break;
        }
      }
      localStorage.setItem("booklist", JSON.stringify(reBook));
      this.$router.push("/booklist");
    },
  }
}
</script>

<style>

</style>