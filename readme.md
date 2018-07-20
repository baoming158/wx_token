### 微信验证Java程序
* 修改SignUtil中token值为微信公众平台后台的code
* 将项目部署到云服务器中，配置域名
* url:http://xxx.xxx.xxx/validata
* 出现 验证完毕则成功
* mvn clean package
* scp target/wx_token-0.0.1-SNAPSHOT.jar 目标机器
* nohup java -jar wx_token-0.0.1-SNAPSHOT.jar > wx.log &

---
或者使用微信官方的Python程序验证地址如下：
https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1472017492_58YV5
