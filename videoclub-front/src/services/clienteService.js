import { url } from './url.js'

class ClienteService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/clientes`
  }
  getAllClientes(){
    return this.axios.get(this.url)
  }
}
export default ClienteService
