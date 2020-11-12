import { createApp } from 'vue'
import App from './App.vue'
import router from './router' 
// import axios from 'axios'

createApp(App).use(router).mount('#app')



//axios 

// axios.defaults.baseURL = 'https://www.qiyuanheshan.com/xnxw'
// axios.defaults.timeout = 10000
// 1基本使用
// axios({
//     u rl: 'https://www.qiyuanheshan.com/xnxw/release/list?schoolId=4',
//     method: 'get'  //默认是get请求，可不传
// }).then(res=>{
//     console.log(res);
// })

// axios({
//     url: 'https://www.qiyuanheshan.com/xnxw/release/list',
//     params: {
//         schoolId: 3
//     }
// }).then(res=>{
//     console.log(res);
// })

// 2.多个请求同时进行(并发请求)

// axios.all([axios({
//     url:'/index/get_prize_draw_status'
// }),axios({
//     url: '/index/get_video_status'
// })]).then(axios.spread((res1,res2)=>{
//     console.log(res1);
//     console.log(res2);

// }))


//3.创建对应的axios实例
// const instance1 = axios.create({
//     baseURL : 'https://www.qiyuanheshan.com/xnxw',
//     timeout : 5000
// })

// instance1({
//     url : '/index/get_video_status'
// }).then(res =>{
//     console.log(res);
// })
 
//4.封装request请求
import {request} from './network/request'

// request({
//     url:'/index/get_video_status'
// },res =>{
//     console.log(res)
// },err =>{
//     console.log(err)
// })

request({
    url:'/index/get_video_status'
}).then(res=>{
    console.log(res)
}).catch(err =>{
    console.log(err)
})