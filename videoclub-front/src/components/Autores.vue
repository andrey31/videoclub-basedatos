<template>

  <b-container>
    <template v-if="autores.length > 0">
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        align="center"
        >
      </b-pagination>
      <b-table
        :items="autores"
        :per-page="perPage"
        :current-page="currentPage"
        >

    </b-table>
    </template>
    <template v-else>
        <b-spinner variant="primary" label="Cargando"></b-spinner>
    </template>

  </b-container>


</template>

<script>
import {mapState} from 'vuex'
export default {
  name: 'autores',
  computed: {
    ...mapState(['autores']),
    rows() {
      return this.autores.length
    }
  },
  data(){
      return {
          perPage: 50,
          currentPage: 1,
      }
    }
}
</script>
