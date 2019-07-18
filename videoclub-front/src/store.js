import Vue from 'vue'
import Vuex from 'vuex'

import services from './services/services'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    services,
    autores: [],
    movies: [],
    moviesFilter: [],
    generos: [],
    lenguajes: [],
    alquiler: {alquiler: false, variant: 'primary'},
    client: {},
    shopping: [],
    clientes: []
  },

  mutations: {
    setMovies: (state, e) => state.movies = e,
    setMoviesFilter: (state, e) => state.moviesFilter = e,
    setAlquiler: (state, e) => state.alquiler = e,
    setClient: (state, e) => state.client = e,
    setShopping: (state, e) => state.shopping.push(e),
    clearShopping: (state) => state.shopping = [],
    setGeneros: (state, e) => state.generos = e,
    setLenguajes: (state, e) => state.lenguajes = e,
    setAutores: (state, e) => state.autores = e,
    setClientes: (state, e) => state.clientes = e
  },
  actions: {
    getAllMovie: function({commit}){
      services.movieService.getAllMovie().then( response => {
        commit('setMovies', response.data)
      }).catch( error => {
        console.log(error)
      })
    },
    getAllGeneros: function( {commit} ){
      services.generoService.getAllGeneros().then( response => {
        commit('setGeneros', response.data)
      }).catch( error => {
        console.log(error)
      })
    },
    getAllLenguajes: function( {commit} ){
      services.lenguajeService.getAllLenguajes().then( response => {
        commit('setLenguajes', response.data)
      }).catch( error => {
        console.log(error)
      })
    },
    getAllAutores: function( {commit} ){

      services.autorService.getAllAutores().then( response => {
        commit('setAutores', response.data)
        console.log(response.data)
      }).catch( error => {
        console.log(error)
      })
    },
    getAllClientes: function( {commit} ){

      services.clienteService.getAllClientes().then( response => {
        commit( 'setClientes', response.data)
      }).catch( error => {
        console.log(error)
      })
    }
  }
})
