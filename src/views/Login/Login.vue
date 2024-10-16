<script>
  export default {
    name: "Login",
    data() {
      return {
        activeTab: 'login',
        loginForm: {
          username: '',
          password: '',
        },
        registerForm: {
          username: '',
          password: '',
          confirmPassword: '',
        },
        rememberPassword: false,
        loginRules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
          ]
        },
        registerRules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
          ],
          confirmPassword: [
            { required: true, message: '请确认密码', trigger: 'blur' },
            { validator: this.validatePassword, trigger: 'blur' }
          ],
        },

      };
    },
        methods: {
          handleLogin(formName) {
            const payload = {
              username: this.loginForm.username,
              password: this.loginForm.password,
            };
            this.$axios.post('http://localhost:8081/user/login', payload, {
              headers: {
                'Content-Type': 'application/json',
              },
            })
                .then(response => {
                  const userCode = response.data.code; // 获取用户数据
                  // 后端返回的 response.data 是封装好的 Result 对象
                  if (response.data.code === "0") {
                    // 登录成功
                    this.$message({
                      message: response.data.msg || '登录成功',
                      type: 'success'
                    });
                    this.$router.push({ path: '/index', query: { username: this.loginForm.username } });// 跳转到 /index 页面
                  } else {
                    // 登录失败
                    this.$message({
                      message: response.data.msg || '登录失败，请检查用户名和密码。',
                      type: 'error'
                    });
                  }
                })
                .catch(error => {
                  // 捕获并打印异常信息
                  console.error('登录请求发生错误:', error);

                  // 增强错误信息输出
                  if (error.response) {
                    // 服务器返回了状态码，但不是 2xx 的范围
                    console.error('错误状态码:', error.response.status);
                    console.error('错误信息:', error.response.data);
                    this.$message({
                      message: error.response.data.msg || '登录请求失败，请稍后重试。',
                      type: 'error'
                    });
                  } else if (error.request) {
                    // 请求已发出，但没有收到响应
                    console.error('请求已发出，但没有收到响应:', error.request);
                    this.$message({
                      message: '请求已发出，但没有收到响应，请检查网络连接。',
                      type: 'error'
                    });
                  } else {
                    // 其他错误
                    console.error('错误信息:', error.message);
                    this.$message({
                      message: '发生错误: ' + error.message,
                      type: 'error'
                    });
                  }
                });
          },

          handleRegister() {
            const payload = {
              username: this.registerForm.username,
              password: this.registerForm.password,
            };
            // 这里可以添加注册请求的逻辑
            console.log('注册信息:', payload);
          },
          validatePassword(rule, value, callback) {
            if (value !== this.registerForm.password) {
              callback(new Error('两次输入的密码不一致'));
            } else {
              callback();
            }
          },

          resetForm(formName) {
            this.$refs[formName].resetFields();
          }

        }

  }

</script>

<template>
  <el-row type="flex" class="row-bg" justify="center">
    <el-col :xl="6" :lg="7">
      <h2>𝕻𝖑𝖊𝖆𝖘𝖊 𝕷𝖔𝖌𝖎𝖓</h2>
      <el-image :src="require('@/assets/login.jpg')" style="height: 180px; width: 180px"></el-image>
      <p>𝖂𝖊𝖑𝖈𝖔𝖒𝖊</p>
    </el-col>

    <el-col :span="1">
      <el-divider direction="vertical"></el-divider>
    </el-col>

    <el-col :xl="6" :lg="7">
      <el-tabs v-model="activeTab">
        <el-tab-pane label="登录" name="login">
          <el-form :model="loginForm" :rules="loginRules" ref="loginForm" label-width="100px">
            <el-form-item label="用户名" prop="username" style="width: 380px">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="password" style="width: 380px">
              <el-input v-model="loginForm.password" type="password"></el-input>
            </el-form-item>

            <el-form-item>
              <el-checkbox v-model="rememberPassword">记住密码</el-checkbox>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="handleLogin('loginForm')">登录</el-button>
              <el-button @click="resetForm('loginForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>

        <el-tab-pane label="注册" name="register">
          <el-form :model="registerForm" :rules="registerRules" ref="registerForm" label-width="100px">
            <el-form-item label="用户名" prop="username" style="width: 380px">
              <el-input v-model="registerForm.username"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="password" style="width: 380px">
              <el-input v-model="registerForm.password" type="password"></el-input>
            </el-form-item>

            <el-form-item label="确认密码" prop="confirmPassword" style="width: 380px">
              <el-input v-model="registerForm.confirmPassword" type="password"></el-input>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="handleRegister">注册</el-button>
              <el-button @click="resetForm('registerForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </el-col>
  </el-row>
</template>

<style scoped>

.el-row {
  position: absolute;
  background-color: #fafafa;
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  text-align: center;
}
.el-divider {
  height: 200px;
}

</style>