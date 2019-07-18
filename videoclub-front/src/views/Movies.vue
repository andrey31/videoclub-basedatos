<template>
<b-container fluid>
  <b-row class="py-2 bg-light mx-0">
    <b-col cols="4" class="text-left">
      <b-button :variant="alquiler.variant" @click="setModalShow()" block>{{getTextButton}}</b-button>
    </b-col>
    <b-col cols="4" offset="4" class="text-right" v-if="!clientUndefined">
      <a href="" @click.stop.prevent="$router.push('/carshopping')">
        <label><b>Cliente: {{client.nombre }} {{client.apellido1}}</b></label>
        <label for="" class="mr-2"></label>
        <v-icon name="shopping-cart" scale="2" class="text-primary"></v-icon><b-badge class="ml-1" variant="dark">{{shopping.length}}</b-badge>
      </a>
    </b-col>
  </b-row>

  <b-tabs class="bg-ligth-custom" card>
    <b-tab
      title="Inicio"
      >

      <b-button variant="primary" block>Alquiler/venta nueva</b-button>
    </b-tab>
    <b-tab
      title="Peliculas para vender o alquilar"
      active
      >
      <b-row>
        <b-col cols="4">
          <label for="">Género</label>
          <b-form-select v-model="genre" class="mt-3">
            <option value="">Todos</option>
            <template v-for="genero in generos">
              <option>{{genero.genero}}</option>
            </template>
          </b-form-select>
        </b-col>
        <b-col cols="4">
          <label for="">Lenguaje</label>
          <b-form-select v-model="lang" class="mt-3">
            <option value="">Todos</option>
            <template v-for="l in lenguajes">
              <option>{{l.lenguaje}}</option>
            </template>
          </b-form-select>
        </b-col>
        <b-col cols="4">
          <label for="">Año</label>
          <b-form-select v-model="year" :options="years" class="mt-3"></b-form-select>
        </b-col>
        <b-col cols="4">

          <label for="">Título</label>
          <b-form-input v-model="title"></b-form-input>
        </b-col>
      </b-row>

      <b-pagination
        v-model="currentPage"
        :total-rows="totalRows"
        :per-page="perPage"
        align="center"
        >
      </b-pagination>
      <b-row>
        <template v-for="i in currentPageItems">

          <b-col cols="6" md="3" lg="2">
            <a href="" v-b-tooltip.hover placement="top" :title="i.descripcion" class="text-dark" @click.stop.prevent="addShopping(i)">

              <b-card
                :title="i.titulo"
                :img-src="i.imgUrl"
                img-alt="Sin imagen"
                img-top
                style="max-width: 15rem; max-height: 60rem;"
                class="mb-2"
                >

                <b-card-text class="h-100">


                </b-card-text>


                <div slot="footer">
                  <b>Duracion: {{i.duracion}}</b> <br/>
                  <b>Genero: {{i.genero.genero}}</b> <br/>
                  <b>Lenguaje: {{i.lenguaje.lenguaje}}</b>

                </div>
              </b-card>
            </a>

          </b-col>
        </template>
      </b-row>
    </b-tab>

    <b-tab
      title="Peliculas Alquiladas"
      >

    </b-tab>
    <b-tab
      title="Peliculas Vendidas"
      >
    </b-tab>

    <b-tab
      title="Facturas"
      >
    </b-tab>
  </b-tabs>

  <b-modal v-model="modalShow" size="xl" title="Seleccione un cliente">
    <b-form-input v-model="filterClient" placeholder="Buscar cliente"></b-form-input>

    <b-table
      selectable
      select-mode="single"
      :items="clientes"
      :filter="filterClient"
      :fields="fieldsCliente"
      @row-selected="rowSelected"
      responsive
      >

      <template slot="nombreCompleto" slot-scope="row">
        {{row.item.nombre}} {{row.item.apellido1}} {{row.item.apellido2}}
      </template>

      <template slot="direccion" slot-scope="row">
        <a href="" @click.prevent="">{{row.item.direccion.direccion}}</a>
      </template>
      <template slot="mail" slot-scope="row">
        {{row.item.email}}
      </template>

      <template slot="numberPhone" slot-scope="row">
        {{row.item.telefono}}
      </template>

      <template slot="more" slot-scope="row">
        <b-button variant="primary" block>Info</b-button>
      </template>
    </b-table>
    <template slot="modal-footer">
      <b-button variant="danger" class="mr-2">Cancelar</b-button>
      <b-button variant="primary" @click="setAlquilerCustom()">Continuar</b-button>
    </template>
  </b-modal>
  <b-modal v-model="modalShoppingShow" title="Agregar a carrito">
    <template v-if="movieModal">
      {{movieModal.titulo}}
    </template>
    <template slot="modal-footer">
      <b-button variant="danger" class="mr-2">Cancelar</b-button>
      <b-button variant="primary" @click="addShopping2">Continuar</b-button>
    </template>
  </b-modal>
</b-container>
</template>
<script>
import AddMovie from '@/components/AddMovie'
import {mapState, mapMutations,mapActions} from 'vuex'

export default {
    name: 'pelicula',
    components: {
        AddMovie
    },
    computed: {
        ...mapState(['movies', 'alquiler', 'client', 'shopping', 'generos', 'lenguajes', 'clientes']),
        years: function(){
            let j = []
            j.push('')
            for (let i = 1970; i <= 2019; i++){
                j.push(i)
            }
            return j
        },
        clientUndefined: function(){
            if (typeof this.client.id === 'undefined') return true
            else return false
        },
        getTextButton: function(){
            let t = this.alquiler.alquiler === false ? 'Nuevo alquiler/venta' : 'Cancelar'
            return t

        },
        filterMovies: function(){
            let mf = this.movies.filter( movie => {
                let r = movie.genero.genero.toLowerCase().indexOf(this.genre.toString().toLowerCase()) > -1 &&
                    movie.lenguaje.lenguaje.toLowerCase().indexOf(this.lang.toString().toLowerCase()) > -1 &&
                    movie.anio.toLowerCase().indexOf(this.year.toString().toLowerCase()) > -1 &&
                    movie.titulo.toLowerCase().indexOf(this.title.toLowerCase()) > -1
                return r
            })
            return mf
        },
        currentPageItems() {
            let lengthAll = this.filterMovies.length;
            if(lengthAll > 0){
                this.nbPages = 0;
                for (let i = 0; i < lengthAll; i = i + this.perPage) {
                    this.paginated_items[this.nbPages] = this.filterMovies.slice(
                        i,
                        i + this.perPage
                    );
                    this.nbPages++;
                }
                return this.paginated_items[this.currentPage-1];
            }else {
                return []
            }

        },
        totalRows(){
            return this.filterMovies.length
        }
    },
    mounted(){
        this.getAllMovie()
        this.getAllGeneros()
        this.getAllLenguajes()
        this.getAllClientes()
    },
    data(){
        return {
            fields: ['titulo', 'duracion'],
            perPage: 50,
            currentPage: 1,
            paginated_items: {},
            nbPages:0,
            title: '',
            genre: '',
            lang: '',
            year: '0',
            modalShow: false,
            modalShoppingShow: false,
            select: 0,
            filterClient: '',
            fieldsCliente: ['nombreCompleto', 'correo', 'tel', 'direccion'],

            movieModal: null
        }
    },
    methods: {
        ...mapMutations(['setAlquiler', 'setClient', 'setShopping', 'clearShopping']),
        ...mapActions(['getAllMovie', 'getAllGeneros', 'getAllLenguajes', 'getAllClientes']),
        setModalShow: function(){
            if (this.clientUndefined) this.modalShow = true
            else {
                this.setAlquiler( {
                    alquiler: false,
                    variant: 'primary'
                })
                this.setClient({})
                this.clearShopping()
            }


        },
        setAlquilerCustom: function(){

            if (this.select.length > 0) {
                this.setAlquiler( {
                    alquiler: true,
                    variant: 'danger'
                })
                this.setClient(this.select[0])
                this.modalShow = false
            }



        },
        rowSelected: function(item){
            this.select = item
        },
        addShopping: function(movie){
            if (!this.clientUndefined) {
                this.movieModal = movie
                this.modalShoppingShow = true
            }

        },
        addShopping2: function(){
            this.modalShoppingShow = false
            this.setShopping(this.movieModal)
        }
    }
  }
</script>
