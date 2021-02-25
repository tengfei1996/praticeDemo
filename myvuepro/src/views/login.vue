<template>
  <div>
    <!-- <div>
      <img src="/assets/login/logo.png" />
    </div> -->
    <Form
      ref="formInline"
      :model="userData"
      :rules="ruleInline"
      class="formStyle"
    >
      <FormItem prop="userAccount">
        <Input type="text" v-model="userData.userAccount" placeholder="账号">
          <Icon type="ios-person-outline" slot="prepend"></Icon>
        </Input>
      </FormItem>
      <FormItem prop="password">
        <Input type="password" v-model="userData.password" placeholder="密码">
          <Icon type="ios-lock-outline" slot="prepend"></Icon>
        </Input>
      </FormItem>
      <FormItem style="text-align: center">
        <Button type="primary" @click="handleSubmit()">登录</Button>
      </FormItem>
    </Form>
  </div>
</template>
<script>
import userOperation from '@/api/userlogin.js'
export default {
  data () {
    return {
      userOperation,
      userData: {
        userAccount: '',
        password: ''
      },
      ruleInline: {
        userAccount: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' },
          { type: 'string', min: 6, message: '密码不能为小于6位', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleSubmit () {
      console.log("1234")
      this.userOperation.userLogin(this.userData).then((res) => {
        if (res.success) {
          this.$Message.success('Success!');
          this.$router.push('/content')
        } else {
          this.$Message.error('loginFail!');
        }
      })
      // this.$refs[name].validate((valid) => {
      //   if (valid) {

      //   } else {
      //     this.$Message.error('Fail!');
      //   }
      // })
    }
  }
}
</script>


<style lang="less" >
.formStyle {
  width: 300px;
  margin-top: 200px;
  margin-left: 600px;

  // input {
  //   border: 1px solid blue;
  // }
  Button {
    width: 200px;
  }
}
</style>

