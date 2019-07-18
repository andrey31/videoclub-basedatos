import { url } from './url.js'

class AutorService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/autores`
  }

  getAllAutores(){
    console.log(this.url)
    return this.axios.get(this.url)
  }

  saveAutor(autor){
    return this.axios.post(this.url, autor)
  }

  putAutor(id, autor){
    return this.axios.put(`${this.url}/${id}`, autor)
  }

  deleteAutor(id, autor){
    return this.axios.delete(`${this.url}/${id}`)
  }
}
export default AutorService
