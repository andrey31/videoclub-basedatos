import { url } from './url.js'

class GeneroService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/generos`
  }

  getAllGeneros(){
    return this.axios.get(this.url)
  }

  saveGenero(genero){
    return this.axios.post(this.url, genero)
  }

  putGenero(id, genero){
    return this.axios.put(`${this.url}/${id}`, genero)
  }

  deleteGenero(id, genero){
    return this.axios.delete(`${this.url}/${id}`)
  }
}
export default GeneroService
