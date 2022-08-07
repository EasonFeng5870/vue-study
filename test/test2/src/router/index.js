import Vue from 'vue'
import Router from 'vue-router'
import ShoppingCart from '../components/ShoppingCart'
import Test from '../components/Test'
import HelloWorld from '../components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/order',
      name: 'Test',
      component: Test
    },
    {
      path: '/shoppingcart',
      name: 'ShoppingCart',
      component: ShoppingCart
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
