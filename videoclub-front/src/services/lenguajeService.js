import { url } from './url.js'

class LenguajeService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/lenguajes`
  }

  getAllLenguajes(){
    return this.axios.get(this.url)
  }

  saveLenguaje(lenguaje){
    return this.axios.post(this.url, lenguaje)
  }

  putLenguaje(id, lenguaje){
    return this.axios.put(`${this.url}/${id}`, lenguaje)
  }

  deleteLenguaje(id, lenguaje){
    return this.axios.delete(`${this.url}/${id}`)
  }
}
export default LenguajeService
