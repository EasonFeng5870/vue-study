<template>
  <div id="app">
    <img src="./assets/logo.png" width="20px" height="20px" v-bind:to="{path: '/'}"/>
    <router-link to="/">首页</router-link>
    <router-link to="/order">我的订单</router-link>
    <router-link to="/shoppingcart">购物车</router-link>
    <router-link to="/test">登录</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-top: 5px;
}
</style>
