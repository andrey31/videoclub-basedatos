<template>
<div id="app">
  <div id="nav">
    <router-link to="/">Inicio</router-link> |
    <router-link to="/movies">Alquiler/Venta</router-link> |
    <router-link to="/settings">Configuración</router-link> |
    <router-link to="/about">Acerca de</router-link>
  </div>
  <router-view/>
</div>
</template>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
  color: white;
  font-size: 18px;
}

#nav a {
  font-weight: bold;
  color: #fff;
}

#nav a.router-link-exact-active {
  /* color: #8aff58; */
  /* color: #709dff; */
  font-size: 20px;
  color: #00ffd5;
}
#body{
  height: 100/;
  /* height: 100vh; */
  background: url('./assets/background.jpg') no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;

}
.bg-ligth-custom{
  background-color: #f8f9faf7
}
</style>
