import { url } from './url.js'

class MovieService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/peliculas`
  }
  getAllMovie(){
    return this.axios.get(this.url)
  }
}
export default MovieService
