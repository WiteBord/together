<template>
<el-container>
  <el-header>
    <el-checkbox-group v-model="checkedQueClass" @change="handleCheckedChange">
      <el-checkbox v-for="queClass in queClassData" :label="queClass" :key="queClass.text">{{queClass.text}}</el-checkbox>
    </el-checkbox-group>
  </el-header>
  <el-main>
    <el-statistic title="当前已刷" :value="doneNum"></el-statistic>
    <el-descriptions class="quesTitle" v-bind:title="que.text" :column="5" border>
        <!-- 展示判断题答案 -->
        <el-descriptions-item  :content-class-name="chooseIsright(que.isright,que)" v-if="que.isright!=null" label="答案">
          <div v-if="que.seeAns">
          {{ que.isright }}
          </div>
        </el-descriptions-item>

        <!-- 展示选择题选项和答案 -->
        <el-descriptions-item :content-class-name="isright(opt.isright,que)" v-else v-for="(opt,optidx) in que.optionsEntityList" :key="optidx" :label="String.fromCharCode(65+optidx)">
          {{opt.text}}
          <div v-if="que.seeAns">
            ({{ opt.isright }})
          </div>
        </el-descriptions-item>
      </el-descriptions>

      <!-- 展示所属题库 -->
      <el-descriptions :column="1" border>
        <el-descriptions-item label="属于题库">{{ que.quesClasstext }}
          <el-button @click="que.seeAns=!que.seeAns" type="info">看答案</el-button>
        </el-descriptions-item>
      </el-descriptions>
    <el-button @click="randomQue()" type="primary">随机一题</el-button>
  </el-main>
  <el-footer></el-footer>
</el-container>
</template>

<script>
import { searchQueByWord,getQueClass
 } from '@/network/api/questionsApi.js'


export default {
  name: 'Random',
  data () {
    return {
      queClassData:[],//所有题库(ID、名称)
      checkedQueClass:[],//选中的题库
      quesData:"",
      AllQuesData:[],
      que:"",
      doneNum:0
    }
  },
  methods:{
    //选择
    handleCheckedChange(value) {
      this.AllQuesData=[];
      for(var i=0;i<value.length;i++){
        this.search("",value[i].id);
      }
    },
    //查找题目
    search(searchWord,queClassValue){
      searchQueByWord(searchWord,queClassValue).then((data)=>{
        this.quesData=data.data
        this.AllQuesData.push(this.quesData)
      })
    },
    randomQue(){
      this.doneNum+=1;
      var classNum=this.getRandomInt(0, this.AllQuesData.length-1);
      var targetClass=this.AllQuesData[classNum];
      this.que=targetClass[this.getRandomInt(0, targetClass.length-1)];
      this.$set(this.que,'seeAns',false);//似乎要放在最后
    },
    getRandomInt(min, max) { 
      return Math.floor(Math.random() * (max - min + 1)) + min; //左右都包括
    },
    //修改答案背景颜色
    isright(isright,que){
      if(isright==='正确'&&que.seeAns===true)
      {
        return 'right'
      }
    },
    chooseIsright(isright,que){
      if(isright==='正确'&&que.seeAns===true)
      {
        return 'right'
      }
      else if(que.seeAns===true){
        return 'false'
      }
    },
  },
  created() {  
  // 组件实例已创建，可以访问到 data 中的数据   
  // 可以在这里发起异步请求或执行初始化操作  
    //查询题库
    getQueClass().then((data)=>{
      this.queClassData=data.data
    })
  },
  mounted(){
    //实例已经挂载到DOM上后调用，此时期已经和DOM进行了关联，可以用$el访问到挂载的DOM元素
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
 .right {
    background: #cdffb3;
  }
  .false{
    background:#ff9583;
  }

</style>
