import Axios from 'axios'
import MovieService from './movieService.js'

Axios.defaults.headers.common.Accept2 = 'application/json'

export default {
  movieService: new MovieService(axios)
}
