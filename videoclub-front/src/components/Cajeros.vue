<template>
<b-container fluid>
  <b-row>
    <b-col cols="12">
      <b-alert :show="showAlertSuccess" variant="primary">Agregado con éxito</b-alert>
    </b-col>
  </b-row>
  <b-row class="pb-2 bg-light text-left">
    <b-col cols="4" class="">
      <b-button variant="primary" @click="setModalSaveShow"><v-icon name="user-plus"></v-icon></b-button>
    </b-col>
  </b-row>
  <b-table
    :items="cajeros"
    :fields="fields"
    responsive
    >

    <template slot="nombreCompleto" slot-scope="row">
      {{row.item.nombre}} {{row.item.apellido1}} {{row.item.apellido2}}
    </template>

    <template slot="direccion" slot-scope="row">
      <a href="" @click.prevent="">{{row.item.direccion.direccion}}</a>
    </template>

    <template slot="acciones" slot-scope="row">
      <b-button variant="secondary" @click="setModalEditShow(row.item)"><v-icon name="edit"></v-icon></b-button>
      <b-button variant="danger"><v-icon name="trash-alt"></v-icon></b-button>
    </template>
  </b-table>
    <b-modal v-model="modalEditShow" :title="titleModal" size="lg">

      <b-container>

        <b-form class="row">

          <b-form-group id="name" label="Nombre" label-for="input-name" class="col-12 col-md-4">
            <b-form-input id="input-name" v-model="cajero.nombre" type="text"required></b-form-input>
          </b-form-group>

          <b-form-group id="lastname1" label="Primer Apellido" label-for="input-lastname" class="col-12 col-md-4">
            <b-form-input id="input-lastname" v-model="cajero.apellido1" type="text" required> </b-form-input>
          </b-form-group>

          <b-form-group id="lastname1" label="Segundo Apellido" label-for="input-lastname2" class="col-12 col-md-4">
            <b-form-input id="input-lastname2" v-model="cajero.apellido2" type="text" required> </b-form-input>
          </b-form-group>

          <b-form-group id="mail" label="Correo" label-for="input-mail" class="col-12">
            <b-form-input id="input-mail" v-model="cajero.email"type="text" required> </b-form-input>
          </b-form-group>

          <b-form-group id="username" label="Nombre de usuario" label-for="input-username" class="col-12 col-md-6">
            <b-form-input id="input-username" v-model="cajero.usuario" type="text" required> </b-form-input>
          </b-form-group>

          <b-form-group id="pass" label="Contraseña" label-for="input-pass" class="col-12 col-md-6">
            <b-form-input id="input-pass" v-model="cajero.contrasena"type="password" required> </b-form-input>
          </b-form-group>

          <b-form-group id="address" label="Direccion" label-for="input-address" class="col-12">
            <b-form-input id="input-address" v-model="cajero.direccion.direccion" type="text" required> </b-form-input>
          </b-form-group>

          <b-form-group id="distrito" label="Distrito" label-for="input-distrito" class="col-12 col-md-12">
            <b-form-input list="list-distritos" v-model="cajero.direccion.distrito.distrito"></b-form-input>


            <datalist id="list-distritos" >
              <option v-for="distrito in distritos">{{ distrito.distrito }} DE {{distrito.canton.canton}}</option>
            </datalist>
          </b-form-group>
          <!-- <b-form-group id="provincia" label="Provincia" label-for="input-provincia" class="col-12 col-md-4"> -->
          <!--   <b-form-select ></b-form-select> -->
          <!-- </b-form-group> -->

          <!-- <b-form-group id="canton" label="Cantón" label-for="input-canton" class="col-12 col-md-4"> -->
          <!--   <b-form-select ></b-form-select> -->
          <!-- </b-form-group> -->

          <!-- <b-form-group id="distrito" label="Distrito" label-for="input-distrito" class="col-12 col-md-4"> -->
          <!--   <b-form-select ></b-form-select> -->
          <!-- </b-form-group> -->

        </b-form>

      </b-container>
      <template slot="modal-footer">
        <b-button variant="danger" class="mr-2">Cancelar</b-button>
        <b-button variant="primary" @click="sendCajero">{{titleModal}}</b-button>
    </template>
  </b-modal>
  </b-container>

</template>

<script>
import {mapState} from 'vuex'
export default {
  name: 'cajeros',
  computed: {
      ...mapState(['services']),

      distritoSelect: function(){

          let s = this.distritos.filter( dist => {
              return `${dist.distrito} DE ${dist.canton.canton}` === this.cajero.direccion.distrito.distrito
          })

          if (s.length > 0){
              return s[0]
          }
          else {
              return {}
          }

    }
  },
  mounted(){
    this.getAllCajeros()
    this.getAllDistritos()
  },
  data(){
    return {
      cajeros: [],
      fields: [ 'nombreCompleto', 'email', 'telefono', 'usuario', 'direccion', 'acciones'],
      distritos: [],
      titleModal: '',
      modalEditShow: false,
      cajero: {
        id: 0,
        nombre: '',
        apellido1: '',
        apellido2: '',
        email: '',
        telefono: '',
        usuario: '',
        contrasena: '',
        direccion: {
          id: 0,
          direccion: '',
          distrito: {
            id: 0
          }
        },
      },
      showAlertSuccess: false,
      showAlertFailed: false,
    }
  },
  methods: {
    getAllCajeros: function(){
      this.cajeros = []
      this.services.cajeroService.getAllCajeros().then( response => {
        this.cajeros = response.data
        this.getAllDistritos()
      }).catch( error => {
        console.log('error cajeros')
      })
    },
    getAllDistritos: function(){
      this.services.lugaresService.getAllDistritos().then( response => {
        this.distritos = response.data
      }).catch( error => {
        console.log('error distritos')
      })
    },
    setModalEditShow: function(cajero){
      this.titleModal = 'Editar'
      this.cajero.id = cajero.id
      this.cajero.nombre = cajero.nombre
      this.cajero.apellido1 = cajero.apellido1
      this.cajero.apellido2 = cajero.apellido2
      this.cajero.email = cajero.email
      this.cajero.telefono = cajero.telefono
      this.cajero.usuario = cajero.usuario
      this.cajero.contrasena = cajero.contrasena

      this.cajero.direccion = {
        id: cajero.direccion.id,
        direccion: cajero.direccion.direccion,
        distrito: {
        }
      }
      this.modalEditShow = true
    },
    setModalSaveShow: function(){
      this.titleModal = 'Nuevo cajero'
      this.cajero.id = 0
      this.cajero.nombre = ''
      this.cajero.apellido1 = ''
      this.cajero.apellido2 = ''
      this.cajero.email = ''
      this.cajero.telefono = ''
      this.cajero.usuario = ''
      this.cajero.contrasena = ''
      this.cajero.direccion = {
        direccion: '',
        distrito: {
          id: 0
        }
      }
      this.modalEditShow = true
    },
    sendCajero: function () {

      this.cajero.direccion.distrito = this.distritoSelect

      if (this.cajero.id > 0) {
        this.services.cajeroService.putCajero(this.cajero.id, this.cajero).then( response => {
          this.getAllCajeros()
          this.showAlertSuccess = true
          this.modalEditShow = false
          console.log(response.data)
        }).catch( error => {
          this.showAlertSuccess = false
          this.modalEditShow = false
          console.log(error)
        })
      }
      else {
        this.services.cajeroService.saveCajero( this.cajero ).then( response => {
          this.getAllCajeros()
          this.showAlertSuccess = true
          this.modalEditShow = false
        }).catch( error => {
          this.showAlertSuccess = false
          this.modalEditShow = false
        })

      }

    },
  }
}
</script>
