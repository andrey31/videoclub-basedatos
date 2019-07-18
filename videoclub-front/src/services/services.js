import Axios from 'axios'
import MovieService from './movieService.js'
import CajeroService from './cajeroService.js'
import LugaresService from './lugaresService.js'
import GeneroService from './generoService.js'
import LenguajeService from './lenguajeService.js'
import AutorService from './autorService.js'
import ClienteService from './clienteService.js'

Axios.defaults.headers.common.Accept2 = 'application/json'

export default {
  movieService: new MovieService(axios),
  cajeroService: new CajeroService(axios),
  lugaresService: new LugaresService(axios),
  generoService: new GeneroService(axios),
  lenguajeService: new LenguajeService(axios),
  autorService: new AutorService(axios),
  clienteService: new ClienteService(axios)
}
