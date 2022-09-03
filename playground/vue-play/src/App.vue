<script>
import Catalog from './components/Catalog.vue';
import Product from './components/Product.vue';
import Cart from './components/Cart.vue';
import Order from './components/Order.vue';
import OrderList from './components/OrderList.vue';
import Help from './components/Help.vue';
import Login from './components/Login.vue';

import { useCartStore } from './stores/cartstore';

export default {
  name: "App",
  setup() {
    const cart = useCartStore();
    return { cart: cart };
  },
  data() {
    return {
      user: {login: 'Guest', openid: ''},
      viewwhat: 'home',
      productunderview: '',
      tmporder: {},
      quant: 0
    };
  },
  components: {
    Catalog,
    Product,
    Cart,
    Order,
    OrderList,
    Help,
    Login
},
  methods: {
    productSelected(p) {
      this.productunderview = p;
      this.viewwhat = "product";
    },
    orderPlaced(o) {
      console.log('Order placed ' + JSON.stringify(o));
      this.tmporder = o;
      this.cart.lineitems.splice(0, this.cart.lineitems.length);
      this.viewwhat = "order";
    },
    addToCart(p, q) {
      this.cart.addToCart(p, q);
      this.viewwhat = 'home';
    }
  },
  mounted() {
    console.log('App Mounted');
    if (localStorage.getItem('user')) 
        this.user = JSON.parse(localStorage.getItem('user'));
  }
}

</script>

<template>
  <header>
    <button @click="viewwhat='home'">Home</button>
    <button @click="viewwhat='catalog'">Products</button>
    <button @click="viewwhat='cart'">Cart({{this.cart.lineitems.length}})</button>
    <button @click="viewwhat='orders'">Orders</button>
    <button @click="viewwhat='help'">Help</button>
    <button @click="viewwhat='login'">Login</button>
  </header>

  <main>
    <p> Debug:   {{ this.cart }}</p>
    <div v-if="viewwhat=='home'">
      <h1>Home Page</h1>
    </div>
    <div v-if="viewwhat=='catalog'">
      <Catalog @product-selected="productSelected"></Catalog>
    </div>

    <div v-if="viewwhat=='product'">
      <Product :product="this.productunderview" @add-to-cart="addToCart"></Product>
    </div>

    <div v-if="viewwhat=='cart'">
      <Cart @product-selected="productSelected" @order-placed="orderPlaced"></Cart>
    </div>

    <div v-if="viewwhat=='orders'">
      <OrderList></OrderList>
    </div>

    <div v-if="viewwhat=='order'">
      <Order :order="this.tmporder"></Order>
    </div>

    <div v-if="viewwhat=='help'">
      <Help></Help>
    </div>

    <div v-if="viewwhat=='login'">
      <Login></Login>
    </div>
  </main>
</template>
