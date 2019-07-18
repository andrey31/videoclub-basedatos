<template>
<b-container class="bg-light">

  <b-table
    :items="shopping"
    :fields="fields"
    responsive
    >
    <template slot="genero" slot-scope="row">
        {{row.item.genero.genero}}
    </template>

    <template slot="lenguaje" slot-scope="row">
        {{row.item.lenguaje.lenguaje}}
      </template>

      <template slot="acciones" slot-scope="row">
        <b-button variant="danger" @click="removeMovie(row.index)"><v-icon name="trash-alt"></v-icon></b-button>
      </template>
    </b-table>


    <!-- <b-row> -->
    <!--   <b-col> -->


    <!--   </b-col> -->
    <!-- </b-row> -->
  </b-container>
</template>

<script>
import {mapState, mapMutations} from 'vuex'
export default{
    name: 'car-shopping',
    computed: {
        ...mapState(['shopping'])
    },
    data(){
        return {
            fields: ['titulo', 'duracion', 'genero', 'cantidad', 'lenguaje', 'acciones']
        }
    },
    methods: {
        removeMovie: function(index){
            this.shopping.splice(index, 1);
        }
    }

}
</script>
