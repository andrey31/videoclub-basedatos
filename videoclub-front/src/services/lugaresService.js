import { url } from './url.js'

class LugaresService {
  constructor (axios) {
    this.axios = axios
    this.url = url
  }

  getAllProvincias(){
    return this.axios.get(`${this.url}/provincias`)
  }
  getAllCantones () {
    return this.axios.get(`${this.url}/cantones`)
  }
  getAllDistritos () {
    return this.axios.get(`${this.url}/distritos`)
  }
}
export default LugaresService
