<template>
  <div class="home">

  </div>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'home',
  mounted(){
    this.axios.get('http://127.0.0.1:8090/peliculas').then( response =>{
      console.log(response)
    }).catch(error => {
      console.log(error)
    })
  },
  components: {

  }
}
</script>
