// 引入
import axios from 'axios'
// 创建实例
const reHttp = axios.create({

})


var rootApi=process.env.API_ROOT

// 配置拦截器
// 添加请求拦截器
reHttp.interceptors.request.use(config=> {
    // 在发送请求之前做些什么
    if (config.url.startsWith('/questions')) {
      // 使用baseURL1
      config.baseURL = "http://"+rootApi+":18883"
    }
    return config;
  }, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
  });

// 添加响应拦截器
reHttp.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response;
  }, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
  });
export default reHttp // 将该实例对外暴露