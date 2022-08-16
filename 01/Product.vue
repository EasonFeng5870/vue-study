<script>
export default {
  data() {
    return {
      quantity: 0
    }
  },
  props: ['id', 'name', 'desc', 'price', 'unit', 'inventory', 'imageurl']
}
</script>

<template>
  <p><img :src="imageurl" :alt="desc" width="20" height="20"/>
  {{id}}-{{name}}</p>
	<p>Price: ${{price}} per {{unit}}</p>
  <input type="number" min="0" max="100" v-model="quantity" size="3" />
  <button>Add to cart</button>
</template>
