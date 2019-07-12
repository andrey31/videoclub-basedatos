<template>
<div id="app">
  <div id="nav">
    <router-link to="/">Inicio</router-link> |
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
  color: #c82333;
}
#body{
  height: 100vh;
  background-image: url('./assets/background.jpg');
  background-position: center; /* Center the image */
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover; /* Resize the background image to cover the entire container */
}
</style>
