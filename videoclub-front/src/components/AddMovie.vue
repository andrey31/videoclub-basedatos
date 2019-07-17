<template>
<b-row>

  <b-col cols="4">
    <label for="">Género</label>
    <b-form-select v-model="genre" :options="genres" class="mt-3"></b-form-select>
  </b-col>
  <b-col cols="4">
    <label for="">Lenguaje</label>
    <b-form-select v-model="lang" :options="langs" class="mt-3"></b-form-select>
  </b-col>
  <b-col cols="4">
    <label for="">Año</label>
    <b-form-select v-model="year" :options="years" class="mt-3"></b-form-select>
  </b-col>
  <b-col cols="4">

    <label for="">Título</label>
      <b-form-input v-model="title"></b-form-input>
  </b-col>
</b-row>


</template>
<script>
import { mapState, mapGetters} from 'vuex'

export default{

    data(){
        return {

            title: '',
            genre: '',
            genres: [
                {value: '', text: ''},
                {value: 'Guerra', text: 'Guerra'},
                {value: 'Acción', text: 'Accion'},
                {value: 'Drama', text: 'Drama'},
            ],
            lang: 0,
            langs: [
                {value: 0, text: 'Inglés'}
            ],
            year: 0,
            years: [
                {value: 0, text: '1980'}
            ]

        }
    }

  }
</script>
