<template>
    <div>
        <p>
            {{message}}
        </p>
        <p>用户名: <input type="text" placeholder="请输入用户名" /></p>
        <p>密码： <input type="text" placeholder="请输入密码" name="密码"/></p>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
            return {
                message: "welcom, hello jason !"
            }
        },
        methods:{

        },
        mounted() {
            
        },
        created(){
            // console.log("created");
            document.title="hello,jason!";
        }
    }
</script>

<style scoped>

</style>
