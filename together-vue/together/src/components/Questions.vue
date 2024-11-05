<template>
<el-container>
  <el-header>
    <el-button type="primary" @click="dialogFormVisible = true">编辑题库</el-button>

    <el-dialog title="编辑题库" :visible.sync="dialogFormVisible">
      <el-form :model="classForm">
        <el-form-item label="题库" label-width="60px">
          <el-select v-model="queClassValue" placeholder="选择题库" filterable clearable>
            <el-option
              v-for="item in queClassData"
              :key="item.id"
              :label="item.text"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="classForm.className" placeholder="输入题库名称"></el-input>
          <el-button type="primary" @click="addQuesClass(classForm.className)">添加题库</el-button>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>


  </el-header>
  <el-main>
    <el-row :gutter="4">
      <!-- 题库选择框 -->
      <el-col :span="4">
        <el-select v-model="queClassValue" placeholder="所属题库" filterable clearable>
          <el-option
            v-for="item in queClassData"
            :key="item.id"
            :label="item.text"
            :value="item.id">
          </el-option>
        </el-select>
      </el-col>
      <!-- 搜索栏 -->
      <el-col :span="16">
        <el-input v-model="searchWord" placeholder="搜索题目内容"></el-input>
      </el-col>
      <!-- 搜索按钮 -->
      <el-col :span="4">
        <el-button @click="search(searchWord,queClassValue,pageSize,currentPage)" type="primary" :loading="isloading">搜索</el-button>
      </el-col>
    </el-row>
    <!-- 结果呈现 -->
    <el-row v-for="(que, queindex) in quesData" :key="queindex">
      <!-- 题目-->
      <el-descriptions class="quesTitle" v-bind:title="pageSize*(currentPage-1)+queindex+1+'. '+'('+que.queType+')'+que.text" :column="5" border>
      
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
    </el-row>

    
  </el-main>
  <el-footer>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[50, 100, 250, 500]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pageAllNum">
    </el-pagination>

  </el-footer>
</el-container>
</template>

<script>
import { searchQueByWord,getQueClass,addQuesClass,searchQueNumByWord
 } from '@/network/api/questionsApi.js'

export default {
  name: 'Questions',
  data () {
    return {
      searchWord: '',
      quesData:'',
      queClassData:'',
      queClassValue:'',
      isloading:false,
      dialogFormVisible:false,
      classForm:{
        className:''


      },
      pageSize:50,
      currentPage:1,
      pageAllNum:0
      
    }
  },
  methods:{
    //查找题目
    search(searchWord,queClassValue,pageSize,currentPage){
      this.isloading=true
      currentPage=1
      this.currentPage=1
      searchQueNumByWord(searchWord,queClassValue).then((data)=>{
        this.pageAllNum=data.data
      })
      searchQueByWord(searchWord,queClassValue,pageSize,currentPage).then((data)=>{
        this.quesData=data.data
        this.isloading=false
        //动态添加属性，否则不会被双向绑定！！！
        for(var i=0;i<this.quesData.length;i++){
          this.$set(this.quesData[i],'seeAns',false)
        }
      })
    },
    addQuesClass(className){
      addQuesClass(className).then((data)=>{
        console.log("添加成功")
      })
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
    handleSizeChange(val) {
      //console.log(`每页 ${val} 条`);
      this.pageSize=val
    },
    handleCurrentChange(val) {
      //console.log(`当前页: ${val}`);
      this.currentPage=val
      searchQueByWord(this.searchWord,this.queClassValue,this.pageSize,this.currentPage).then((data)=>{
        console.log(data,this.currentPage)
        this.quesData=data.data
        this.isloading=false
        //动态添加属性，否则不会被双向绑定！！！
        for(var i=0;i<this.quesData.length;i++){
          this.$set(this.quesData[i],'seeAns',false)
        }
      })
    }
  },
  created() {  
  // 组件实例已创建，可以访问到 data 中的数据   
  // 可以在这里发起异步请求或执行初始化操作  
  //获取题库
    getQueClass().then((data)=>{
      this.queClassData=data.data
    })
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
  .quesTitle {
    text-align: left;
    margin-bottom: 0px;
    margin-top: 20px;
  }
</style>
