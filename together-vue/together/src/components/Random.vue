<template>
<el-container>
  <el-header>
  </el-header>
  <el-main>
    <el-calendar>
      <template
        slot="dateCell"
        slot-scope="{date, data}"
        >
        <div :class="dayDif(data)">
          {{ data.day.split('-').slice(1).join('-') }}
          {{dayDif(data) }}
        </div>
      </template>
    </el-calendar>
  </el-main>
  <el-footer></el-footer>
</el-container>
</template>

<script>

export default {
  name: 'Random',
  data () {
    return {
      cellBack:''
    }
  },
  methods:{
    dayDif(date){
      var diff=(new Date(date.day)-new Date(2024, 5, 17)-(1000 * 60 * 60 * 8))/ (1000 * 60 * 60 * 24)
      var name=null
      if(diff%12==10){
        name="何浚霖"
      }else if(diff%12==9){
        name="冯智超"
      }
      this.cellBack=name
      return name
    }
  },
  created() {  
  // 组件实例已创建，可以访问到 data 中的数据   
  // 可以在这里发起异步请求或执行初始化操作  

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.何浚霖 {
  background-color: rgb(55, 232, 238); /* Adjust the color as needed */
  height: 100%;
}

.冯智超 {
  background-color: rgb(255, 174, 52); /* Adjust the color as needed */
  height: 100%;
}

</style>
