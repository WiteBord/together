import reHttp from '@/network/request.js'

// 查找题目
export const searchQueByWord = (word,queClassId) => {
  // 这里会返回一个promise对象
  return reHttp({
            method: 'GET',
            url: '/questions/searchQues',
            params:{
              word:word,
              queClassId:queClassId
            }// 按需接收
        })
}

//获取题库
export const getQueClass = () => {
  // 这里会返回一个promise对象
  return reHttp({
            method: 'GET',
            url: '/questions/getQuesClass'
        })
}

//添加题库
export const addQuesClass = (className) => {
  // 这里会返回一个promise对象
  return reHttp({
            method: 'post',
            url: '/questions/addQuesClass',
            data:{text:className}
        })
}
