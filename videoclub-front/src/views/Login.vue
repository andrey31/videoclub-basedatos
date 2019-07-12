<template>
<b-container class="bg-container">
  <b-row class="first-row">

    <b-col cols="12" md="6" offset-md="3">
      <b-alert v-model="showAlert" variant="danger">Usuario incorrecto</b-alert>

      <b-form @submit.prevent="login" class="form-login bg-light">
        <!-- <label for="inputEmail">Correo</label> -->
        <!-- <b-input id="inputEmail"></b-input> -->
        <b-form-group
          id="username"
          label="Nombre de usuario"
          label-for="inputUsername"
          class="custom-text"
          >
          <b-form-input
            id="inputUsername"
            type="text"
            v-model="form.username"
            required
            placeholder="Ingrese su usuario"
            >
          </b-form-input>

        </b-form-group>

        <b-form-group
          id="pass"
          label="Contraseña"
          label-for="inputPass"
          class="custom-text"
          >
          <b-form-input
            id="inputPass"
            type="password"
            v-model="form.password"
            required
            placeholder="Ingrese su contraseña"
            >

          </b-form-input>
        </b-form-group>

        <b-button type="submit" variant="info" class="text-dark" size="lg" block>Ingresar</b-button>

      </b-form>

    </b-col>

  </b-row>
</b-container>
</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      form: {
        username: '',
        password: ''
      },
      showAlert: false
    }
  },
  methods: {
    login: function () {
      this.showAlert = true
    }
  }

}
</script>

<style scoped>
.first-row{
    padding-top: 80px
}
.custom-text{
    color: #343a40;
    font-size: 18px;
}
.form-login{
    /* background: #f5f5f5; */

    /* top | right | bottom | left */
    padding-top: 50px;
    padding-bottom: 50px;
    padding-left: 30px;
    padding-right: 30px;
    /* border: 2px solid ; */
    border-radius: 10px;

    /* border: 4px solid black; */

}
.bg-container{

}
</style>
