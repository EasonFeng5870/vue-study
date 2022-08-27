<script>
export default {
  data() {
    return {
      quantity: 0
    }
  },
  props: {
    product: Object
  },
  emits: ["addToCart"]
}
</script>

<template>
  <p>
    <!--img :src="product.imageurl" :alt="product.desc" width="20" height="20"/-->
    {{ product.id }} - {{ product.name }}
  </p>
	<p>Price: ${{product.price}} per {{product.unit}}</p>
  <input type="number" min="0" max="100" v-model="this.quantity" size="3" />
  <button @click.stop="$emit('addToCart', product, quantity)">Add to cart</button>
</template>
