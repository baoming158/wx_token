package com.andybob.weixin.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Author : baoming  20/07/2018.
 * description :
 */
@Controller
public class ValidationController {

    private Logger logger = LoggerFactory.getLogger(ValidationController.class);
    @RequestMapping(value = "/sayHelly",method = {RequestMethod.GET})
    @ResponseBody
    public String sayHelly(){
        return "ni hao";
    }

    /**
     * 验证方法
     * @param request
     * @return
     */
    @RequestMapping(value = "validata",method = {RequestMethod.GET})
    @ResponseBody
    public String validata(HttpServletRequest request){
        //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp，nonce参数
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("[signature: "+signature + "]<-->[timestamp: "+ timestamp+"]<-->[nonce: "+nonce+"]<-->[echostr: "+echostr+"]");
            return echostr;
        }
        return "验证失败！";
    }
}
