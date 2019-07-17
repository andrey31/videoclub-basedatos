import Vue from 'vue'
import Vuex from 'vuex'

import services from './services/services'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    services,
    movies: [],
    moviesFilter: [],
    alquiler: {alquiler: false, variant: 'primary'},
    client: {},
    shopping: []
  },

  mutations: {
    setMovies: (state, e) => state.movies = e,
    setMoviesFilter: (state, e) => state.moviesFilter = e,
    setAlquiler: (state, e) => state.alquiler = e,
    setClient: (state, e) => state.client = e,
    setShopping: (state, e) => state.shopping.push(e),
    clearShopping: (state) => state.shopping = []
  },
  actions: {
    getAllMovie: function({commit}){
      services.movieService.getAllMovie().then( response => {
        commit('setMovies', response.data)
      }).catch( error => {
        console.log(error)
      })
    }
  }
})
