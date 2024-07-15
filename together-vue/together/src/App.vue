<template>
  <div id="app">
    <el-menu :default-active="$route.path" class="el-menu-demo" mode="horizontal" @select="handleSelect" :router="true">
      <el-menu-item index="/Questions">题库</el-menu-item>
      <el-menu-item index="/Random">随机</el-menu-item>
      <el-menu-item index="/Grades">打分</el-menu-item>
    </el-menu>
    
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
      return {

      };
    },
  methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>
