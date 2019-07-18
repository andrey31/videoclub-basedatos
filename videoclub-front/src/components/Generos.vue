<template>
<b-container fluid>
  <b-row>
    <b-col cols="6">
      <b-table
        :items="generos"
        :fields="fieldsGeneros"
        >
        <template slot="acciones" slot-scope="row">
          <b-button variant="secondary" @click=""><v-icon name="edit"></v-icon></b-button>
          <b-button variant="danger"><v-icon name="trash-alt"></v-icon></b-button>
        </template>
      </b-table>
    </b-col>
    <b-col cols="6">
      <b-table
        :items="lenguajes"
        :fields="fieldsLenguajes"
        >

        <template slot="acciones" slot-scope="row">
          <b-button variant="secondary" @click=""><v-icon name="edit"></v-icon></b-button>
          <b-button variant="danger"><v-icon name="trash-alt"></v-icon></b-button>
        </template>

      </b-table>
    </b-col>
  </b-row>
</b-container>
</template>

<script>
import {mapState} from 'vuex'
export default {
    computed: {
        ...mapState(['generos', 'lenguajes']),
    },
    data(){
        return {
            fieldsGeneros: ['genero', 'acciones'],
            fieldsLenguajes: ['lenguaje', 'acciones']
        }
    }
}
</script>
