import axios from 'axios'


export function request(config){
    //1.创建axios实例
    const instance = axios.create({
        baseURL : 'http://test.qiyuanheshan.com/xnxw',
        timeout : 5000
    })

    //2.axios拦截器
    instance.interceptors.request.use(config=>{
        console.log(config);
        return config
    },err =>{
        console.log(err)
    })

    instance.interceptors.response.use(res =>{
        console.log(res)
        return res;
    },err=>{
        console.log(err)
    })

    //3.发送真正的网络请求
    return instance(config)
    
}


// export function request(config){
//     return new Promise((resolve,reject) =>{
//         //1.创建axios实例
//         const instance = axios.create({
//             baseURL : 'http://test.qiyuanheshan.com/xnxw',
//             timeout : 5000
//         })

//         //发送真正的网络请求
//         instance(config).then(res=>{
//             resolve(res)
//         }).catch(err=>{
//             reject(err)
//         })
//     })
    
// }

// export function request(config,success,failure){
//     //1.创建axios实例
//     const instance = axios.create({
//         baseURL : 'http://test.qiyuanheshan.com/xnxw',
//         timeout : 5000
//     })

//     //发送真正的网络请求
//     instance(config).then(res =>{
//         success(res)
//     }).catch(err =>{
//         failure(err)
//     })
// }