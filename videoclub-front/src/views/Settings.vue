<template>
<b-container fluid>
  <b-tabs class="bg-ligth-custom" card>
    <b-tab
      title="Cajeros"
      >
      <cajeros></cajeros>
    </b-tab>
    <b-tab
      title="Peliculas"
      >
    </b-tab>
    <b-tab
      title="Generos/Lenguajes"
      >
      <generos></generos>
    </b-tab>
    <b-tab
      title="Autores"
      @click="cargarTodosAutores"
      >
      <autores></autores>
    </b-tab>
  </b-tabs>
</b-container>
</template>

<script>
import cajeros from '@/components/Cajeros.vue'
import generos from '@/components/Generos.vue'
import autores from '@/components/Autores.vue'
import {mapState, mapActions} from 'vuex'

export default {
  name: 'settings',
  computed: {
    ...mapState(['services'])
  },
  components: {
    cajeros,
    generos,
    autores
  },
  methods: {
    ...mapActions(['getAllAutores']),
    cargarTodosAutores: function(){
      this.getAllAutores()

    }
  }

}
</script>
