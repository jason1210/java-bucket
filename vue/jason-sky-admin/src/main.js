import { createApp } from 'vue'
import App from './App.vue'
import router from './router' 
import axios from 'axios'

createApp(App).use(router).mount('#app')


//axios 
// 1基本使用
// axios({
//     url: 'https://www.qiyuanheshan.com/xnxw/release/list?schoolId=4',
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

axios.all([axios({
    url:'https://www.qiyuanheshan.com/xnxw/index/get_prize_draw_status'
}),axios({
    url: 'https://www.qiyuanheshan.com/xnxw/index/get_video_status'
})]).then(axios.spread((res1,res2)=>{
    console.log(res1);
    console.log(res2);

}))
 