import { url } from './url.js'

class CajeroService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/cajeros`
  }

  getAllCajeros(){
    return this.axios.get(this.url)
  }

  saveCajero(cajero){
    return this.axios.post(this.url, cajero)
  }

  putCajero(id, cajero){
    return this.axios.put(`${this.url}/${id}`, cajero)
  }

  deleteCajero(id, cajero){
    return this.axios.delete(`${this.url}/${id}`)
  }
}
export default CajeroService
