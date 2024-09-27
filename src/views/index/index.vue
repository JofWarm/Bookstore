<script >


</script>

<template>
  <div id="index">
    <el-container>
      <el-header style="height: 35px;">
        <ul>
          <li>
            <div class="userImg">
              <el-avatar icon="el-icon-s-custom"></el-avatar>
              <!-- 把用户名传递过来 -->
              欢迎{{ $route.params.name }}
            </div>
          </li>
          <li @click='changePage("index")'>商城首页</li>
          <li @click='changePage("ShopCart")'>购物车</li>
          <li @click='changePage("PerCenter")'>个人中心</li>
          <li @click='changePage("exit")'>退出登录</li>
        </ul>
      </el-header>
      <el-main>
        <div>
          <p>
            <input type="search" name="" id="" value="" placeholder="请输入搜索内容" />
            <el-button type="primary" icon="el-icon-search">搜索</el-button>
          </p>
        </div>
        <div>
          <el-tabs v-model="activeName" @tab-click="handleClick">

            <el-tab-pane label="每日推荐" name="first">
              <div class="book-container">

                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/time.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《时间的秩序》</h3>
                    <p>作者: 卡尔·萨根</p>
                    <p>价格: ¥65.00</p>
                    <p>简介: 本书从科学的角度探讨时间的本质，讲述时间如何影响我们的生活与宇宙，是一部思维启发的作品...</p>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/renleijianshi.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《人类简史》</h3>
                    <p>作者: 尤瓦尔·赫拉利</p>
                    <p>价格: ¥70.00</p>
                    <p>简介: 这本书通过跨越几千年的历史，阐述了人类的发展与变迁，揭示了文明背后的复杂性与未来的可能性...</p>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/jieyou.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《解忧杂货店》</h3>
                    <p>作者: 东野圭吾</p>
                    <p>价格: ¥55.00</p>
                    <p>简介: 本书讲述了一家能解忧的杂货店，通过信件的方式解决人们的烦恼，故事温暖而感人，充满人性光辉...</p>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/weicheng.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《围城》</h3>
                    <p>作者: 钱钟书</p>
                    <p>价格: ¥60.00</p>
                    <p>简介: 这是一部描绘知识分子婚姻与生活的经典小说，讽刺了社会的种种不合理现象，深入探讨了人性的复杂...</p>
                  </el-card>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="历史名著" name="second">
              <div class="book-container">
                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/xiyouji.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《西游记》</h3>
                    <p>作者: 吴承恩</p>
                    <p>价格: ¥45.00</p>
                    <p>简介: 该书通过唐僧师徒四人西天取经的故事，反映了人性、友情、信仰等主题，情节引人入胜...</p>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/1984.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《1984》</h3>
                    <p>作者: 乔治·奥威尔</p>
                    <p>价格: ¥45.00</p>
                    <p>简介: 该书描绘了一个极权政府控制下的未来世界，探讨了自由与监控的主题，是反乌托邦文学的经典...</p>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/bainiangudu.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《百年孤独》</h3>
                    <p>作者: 加西亚·马尔克斯</p>
                    <p>价格: ¥75.00</p>
                    <p>简介: 本书通过描绘布恩迪亚家族的兴衰历程，展现了拉丁美洲的魔幻现实主义，深刻影响了世界文学...</p>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/sanguoyanyi.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《三国演义》</h3>
                    <p>作者: 罗贯中</p>
                    <p>价格: ¥68.00</p>
                    <p>简介: 以东汉末年到三国时期为背景，描写了众多英雄人物的智谋与胆略，是中国古典小说中的巅峰之作...</p>
                  </el-card>
                </div>
              </div>

            </el-tab-pane>
            <el-tab-pane label="流行小说" name="third">
              <div class="book-container">
                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/hari.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《哈利·波特与魔法石》</h3>
                    <p>作者: J.K. 罗琳</p>
                    <p>价格: ¥55.00</p>
                    <p>简介: 这是哈利·波特系列的第一部，讲述了一个普通男孩在魔法世界中的冒险与成长，他的故事启发了...</p>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/nuowei.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《挪威的森林》</h3>
                    <p>作者: 村上春树</p>
                    <p>价格: ¥48.00</p>
                    <p>简介: 这部小说描绘了一段关于爱情、失落与成长的故事，通过主人公的视角，展示了60年代的日本社会...</p>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/zhigengniao.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《杀死一只知更鸟》</h3>
                    <p>作者: 哈珀·李</p>
                    <p>价格: ¥42.00</p>
                    <p>简介: 该书通过孩子的视角探讨了种族歧视和道德成长的问题，是美国文学中的经典之作，感人至深...</p>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/xiaowangzi.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《小王子》</h3>
                    <p>作者: 安东尼·德·圣埃克苏佩里</p>
                    <p>价格: ¥35.00</p>
                    <p>简介: 本书以简单的故事传达深刻的哲理，讲述了一位小王子在宇宙中的旅行与思考，适合各年龄层读者...</p>
                  </el-card>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="网络小说" name="fourth">
              <div class="book-container">

                <div class="book-row">
                  <!-- 第一部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/quanzhigaoshou.png" alt="书籍封面1" class="book-cover">
                    <h3>书名: 《全职高手》</h3>
                    <p>作者: 蝴蝶蓝</p>
                    <p>价格: ¥55.00</p>
                    <p>简介: 讲述了职业战队的顶级选手叶修在退役后重返电竞界的故事，展现了电竞的魅力与热血...</p>
                  </el-card>

                  <!-- 第二部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/zetian.png" alt="书籍封面2" class="book-cover">
                    <h3>书名: 《择天记》</h3>
                    <p>作者: 猫腻</p>
                    <p>价格: ¥48.00</p>
                    <p>简介: 故事围绕一个年轻人寻找自身命运与责任的旅程，结合了历史与幻想，情节跌宕起伏，令人向往...</p>
                  </el-card>

                  <!-- 第三部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/doupocangqiong.png" alt="书籍封面3" class="book-cover">
                    <h3>书名: 《斗破苍穹》</h3>
                    <p>作者: 天蚕土豆</p>
                    <p>价格: ¥60.00</p>
                    <p>简介: 讲述了少年萧炎通过努力不断成长，逆袭崛起的热血传奇故事，充满了友情与挑战...</p>
                  </el-card>

                  <!-- 第四部书 -->
                  <el-card class="book-card" shadow="hover">
                    <img src="./pictures/dazhuzai.png" alt="书籍封面4" class="book-cover">
                    <h3>书名: 《大主宰》</h3>
                    <p>作者: 天蚕土豆</p>
                    <p>价格: ¥58.00</p>
                    <p>简介: 本书讲述了一个少年在异界拼搏、成长与寻找真相的冒险故事，充满热血与感动，吸引了无数读者...</p>
                  </el-card>
                </div>
              </div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#index {
  position: absolute;
  display: flex;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  /* background-color: #FF0000; */

}

.el-header {
  background-color: #cccccc;
  color: #333;
  text-align: center;
  height: 5%;
  line-height: 25px;
}

.el-main {
  background-color: rgba(173, 216, 230, 0.1); /* 半透明的浅蓝色背景 */
  color: #000000; /* 黑色文字，确保在浅色背景上清晰可见 */
  text-align: center;
  height: 95%;
}

.el-container {
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
}

.el-header>ul {
  position: absolute;
  right: 5px;
}

.el-header>ul>li {
  float: left;
  list-style: none;
  margin: 5px;
  user-select: none;
}

.el-header>ul>li:not(:first-child):hover {
  color: red;
  text-decoration: underline;
}

.el-avatar {
  position: absolute;
  left: -30px;
  top: 2px;
  width: 33px;
  height: 30px;
  color: #42B983;
  /* border: 1px solid #0000FF; */
}

.el-avatar--icon {
  font-size: 35px;
}

.userImg {
  display: flex;
  /* align-items: center; */
  vertical-align: middle;
}

input[type="search"] {
  width: 600px;
  height: 35px;
  font-size: 15px;
  outline: none;
  border: 2px solid #0000FF;
  border-radius: 5px;
}

.el-button {
  padding: 10px 20px;
  width: auto;
  height: 35px;
  font-size: 15px;
  text-align: center;
  margin-left: 10px;
}

.el-main>div {
  margin-top: 5px;
  /* background-image: url(../assets/7.png); */
}

.el-main>div:nth-of-type(2) {
  position: absolute;
  width: 88%;
  left: 50%;
  transform: translate(-50%, 0);
  /* background-color: #0000FF; */
  /* background-image: url(../assets/7.png); */
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  /* margin-right: 5px;
  margin-bottom: 15px; */
}

.button {
  padding: 0;
  float: right;
  margin-right: 34px;
  margin-top: 9px;
}

.image {
  /* position: absolute; */
  margin: 0 auto;
  width: 90%;
  display: block;
  border-radius: 10px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.el-menu-demo {
  /* background-color: #0000FF; */
  font-size: 25px;
  color: #cccccc;
}
.el-submenu{
  height: 28px;
}
.el-submenu__title{
  font-size: 20px;
  color: #cccccc;
  margin-top: -18px;
  height: 28px;
}
.el-submenu__title:hover{
  height: 28px;
}
.el-menu--horizontal>.el-submenu .el-submenu__title{
  height: 28px;
  line-height: 28px;
  /* background-color: red; */
  font-size: 20px;
  color: #cccccc;
}
.el-submenu{
  font-size: 20px !important;
  color: #cccccc !important;
  background-color: transparent !important;
  /* background-color: red !important; */
}

.book-container {
  padding: 20px;
  text-align: center;
}

.book-row {
  display: flex;
  flex-wrap: wrap; /* 如果屏幕宽度不足，书籍会自动换行 */
  justify-content: space-between; /* 水平排列的书籍之间有相同的间距 */
  gap: 20px; /* 书籍之间的间距 */
}

.book-card {
  width: 23%; /* 每本书占据容器的 23%，适合四本书水平排列 */
  padding: 15px;
  border-radius: 8px;
  box-sizing: border-box; /* 确保 padding 不影响宽度 */
}

.book-cover {
  width: 100%;
  height: auto;
  border-radius: 4px;
  margin-bottom: 15px;
}

h3 {
  font-size: 18px;
  margin: 10px 0;
}

p {
  color: #666;
  font-size: 14px;
  margin-top: 10px;
}

.el-card{
  flex-direction: column;
  height: 1000px;
  margin-top: auto;
  display: flex;
}
</style>