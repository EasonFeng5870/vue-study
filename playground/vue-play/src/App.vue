<script>
import Catalog from './components/Catalog.vue'
import Product from './components/Product.vue'

let cart = {
    lineitems: [],
    total: 0
};
let tmporder = {
    lineitems: [],
    address: null,
    payment: null,
    tax: 0,
    total: 0
};

export default {
  name: "App",
  data() {
    return {
      viewwhat: "home",
      productunderview: '',
      cart: cart,
      tmporder: tmporder,
      quant: 0
    };
  },
  components: {
  Product,
  Catalog
  },
  methods: {
    productSelected(p) {
      this.viewwhat = "product";
      this.productunderview = p;
    },
    addToCart(p, q) {
      let lineitem = {p, q};
      this.cart.lineitems.push(lineitem);
      this.viewwhat = 'home';
    }
  }
}

</script>

<template>
  <header>
    <button @click="viewwhat='home'">Home</button>
    <button @click="viewwhat='catalog'">Products</button>
    <button @click="viewwhat='cart'">Cart({{cart.lineitems.length}})</button>
    <button @click="viewwhat='orders'">Orders</button>
    <button @click="viewwhat='help'">Help</button>
    <button @click="viewwhat='login'">Login</button>
  </header>

  <main>
    <div v-if="viewwhat=='catalog'">
      <Catalog @product-selected="productSelected"></Catalog>
    </div>

    <div v-if="viewwhat=='product'">
      <Product :product="this.productunderview" @add-to-cart="addToCart"></Product>
    </div>
  </main>
</template>
