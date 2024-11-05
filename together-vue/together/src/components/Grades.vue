<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="14">
        <el-card shadow="hover" style="width: 100%; padding:0px;">
          <div slot="header" class="clearfix">
            <span>AAa</span>
          </div>
          <div style="width: 100%; display: inline-block; ">
            <el-col :span="4"><el-result style="padding:0px;"  icon="success" :title="teamZX[0]"></el-result></el-col>
            <el-col :span="4"><el-result style="padding:0px;"  icon="success" :title="teamZX[0]"></el-result></el-col>
            <el-col :span="4"><el-result style="padding:0px;"  icon="success" :title="teamZX[0]"></el-result></el-col>
            <el-col :span="4"><el-result style="padding:0px;"  icon="info" title=""></el-result></el-col>
            <el-col :span="4"><el-result style="padding:0px;"  icon="info" title=""></el-result></el-col>

          </div>
        </el-card>


      </el-col>
      <el-col :span="10">
      <el-card shadow="hover" style="width: 100%;  padding:0px;">
          <div slot="header" class="clearfix">
            <span>实时排名</span>
          </div>
          <div style="font-size: 18px;text-align: center;">aa  XX分</div>
          <div style="font-size: 18px;text-align: center;">bb   XX分</div>
          <div style="font-size: 18px;text-align: center;">cc   XX分</div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
  name: 'Grades',
  data () {
    return {
      teamZX:["10",12,13,14,15]
    }
  },
  methods:{
    
  },
  created() {  
  // 组件实例已创建，可以访问到 data 中的数据   
  // 可以在这里发起异步请求或执行初始化操作  

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >


</style>
