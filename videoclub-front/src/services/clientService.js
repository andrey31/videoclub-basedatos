import { url } from './url.js'

class ClientService {
  constructor (axios) {
    this.axios = axios
    this.url = `${url}/clients`
  }
  getAllClient(){
    return this.axios.get(this.url)
  }
}
export default ClientService
