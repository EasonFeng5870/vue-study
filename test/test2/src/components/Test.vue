<template>
  <div class="hello">
    <h1>{{ message }}</h1>
    <div>
      <table border="1">
        <tr>
          <th>序号</th>
          <th>订单名称</th>
          <th>数量</th>
        </tr>
        <tr>
          <td>1</td>
          <td>电动摩托车</td>
          <td>1</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Test',
  data () {
    return {
      message: '我的订单列表'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
