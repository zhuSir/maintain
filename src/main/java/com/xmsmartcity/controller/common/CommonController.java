package com.xmsmartcity.controller.common;

import com.alibaba.fastjson.JSON;
import com.xmsmartcity.pojo.CommonObjParam;
import com.xmsmartcity.pojo.CommonObjReturn;
import com.xmsmartcity.pojo.CommonSecurityObjParam;
import com.xmsmartcity.pojo.ErrorRecord;
import com.xmsmartcity.util.AjaxHelper;
import com.xmsmartcity.util.CalendarHelper;
import com.xmsmartcity.util.CookieHelper;
import com.xmsmartcity.util.DeviceHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by BinYiChen on 2018/1/23.
 */

@Controller
public class CommonController {

    private static final Logger logger = Logger.getLogger(CommonController.class);

    // spring反射代理类
    @Autowired
    private SpringContextsController springContextsController;

    /*
     *
	 * 报文提交主接口，只做必要的鉴定和认证，然后反射递交到后续处理模块
	 *
	 */
    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public @ResponseBody
    CommonObjReturn doCommonApi(@RequestBody CommonObjParam objparam, HttpServletRequest request,
                                HttpServletResponse response) {
        CommonObjReturn json_obj_return = null;
        CommonSecurityObjParam commonSecurityObjParam = null;
        String funcName = "";
        String serviceName = "";
        String accessTocken = "";
        String serialNumber = "";
        String reqTime = "";
        String smsCode = "";
        String emailCode = "";
        String userAccount = "";
        String reqSysCode = "";
        String deviceId = "";
        Object data = null;
        Date tempDateForCheck = null;
        try {
            try {
                logger.info("开始处理CommonApi, 提交的参数为：" + JSON.toJSONString(objparam));
                // 结构体解析与通用参数获取
                funcName = objparam.getFuncName().toString();
                serviceName = objparam.getServiceName().toString();
                serialNumber = objparam.getSerialNumber().toString();
                reqTime = objparam.getReqTime().toString();
                userAccount = objparam.getUserAccount();
                if (StringUtils.isEmpty(userAccount)) {
                    userAccount = CookieHelper.getCookie("u", request);
                    if (StringUtils.isEmpty(userAccount)) {
                    } else {
                        // cookie值补回报文体
                        objparam.setUserAccount(userAccount);
                    }
                }

                reqSysCode = objparam.getReqSysCode().toString();
                if ((!DeviceHelper.isWeb(reqSysCode)) && (!DeviceHelper.isMobile(reqSysCode))) {
                    return AjaxHelper.newFaildForSystemError();
                }

                // security层参数获取
                commonSecurityObjParam = objparam.getSecurity();
                deviceId = commonSecurityObjParam.getDeviceId();
                smsCode = commonSecurityObjParam.getSmsCode();
                emailCode = commonSecurityObjParam.getEmailCode();
                accessTocken = commonSecurityObjParam.getAccessTocken();

                if (StringUtils.isEmpty(accessTocken)) {
                    accessTocken = CookieHelper.getCookie("at", request);
                    if (StringUtils.isEmpty(accessTocken)) {
                    } else {
                        // cookie值补回报文体
                        commonSecurityObjParam.setAccessTocken(accessTocken);
                    }
                }

                // 数据层获取，这里不做进一步解析
                data = objparam.getData();

                // 请求时间校验，需要精确到毫秒
                tempDateForCheck = CalendarHelper.parseDateWithMillisecond(reqTime);

            } catch (Exception e) {
                // TODO: handle exception
                logger.error(e);
                e.printStackTrace();
                // 解析报文体出错，一般情况是非法报文
                return AjaxHelper.newFaildForSystemError();

            }

            // 清除传入结构体中不能包含的敏感信息，这部分信息将在验证通过后自动补入
            objparam.setUserEmail("");
            objparam.setUserId("");
            objparam.setUserMobileNumber("");
            objparam.setUserName("");

            // 反射跳转
            json_obj_return = reInvoke(serviceName, funcName, objparam, request, response);

            if (json_obj_return != null)
                return json_obj_return;
            else
                // 无法获取业务模块的任何返回，很可能的原因是：业务模块出现无法预料的错误，并且没有抛出错误到common层
                // 这个时候必须做统一的出错处理
                return AjaxHelper.newFaildForSystemError();

        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            // 这个是最终的catch层，理论上不可能到这里，如果到这里说明系统发生严重错误且属于未知情况
            // 这里不能使用errorRecordService的原因，是因为可能出现数据库无响应的情况，所以只能一切手工建立
            // 简单说，到达这里的错误必须人工干预，且需要尽快
            ErrorRecord er = new ErrorRecord();
            er.setErrStack(ExceptionUtils.getStackTrace(e));
            er.setCode("sys_0000");
            er.setComment("系统遇到内部错误，请联系管理员");
            return AjaxHelper.newFaildForBusinessError(er, null);
        }
    }

    /*
     *
     * 根据bean名称进行反射跳转，转交事务
     *
     */
    private CommonObjReturn reInvoke(String beanName, String methodName, CommonObjParam objparam,
                                     HttpServletRequest request, HttpServletResponse response) {
        Method method = null;
        try {
            method = ReflectionUtils.findMethod(springContextsController.getBean(beanName).getClass(), methodName,
                    CommonObjParam.class, HttpServletRequest.class);
        } catch (Exception e) {
            // 反射错误，一般是没有对应的controll，或者controller没有注解命名
            logger.error(e);
            e.printStackTrace();
            return AjaxHelper.newFaildForSystemError();
        }

        if (method == null) {
            // 再次尝试3个参数的组合
            try {
                method = ReflectionUtils.findMethod(springContextsController.getBean(beanName).getClass(), methodName,
                        CommonObjParam.class, HttpServletRequest.class, HttpServletResponse.class);
            } catch (Exception e) {
                // 反射错误，一般是没有对应的controll，或者controller没有注解命名
                logger.error(e);
                e.printStackTrace();
                return AjaxHelper.newFaildForSystemError();
            }
        }

        if (method == null) {
            // 再次尝试只有一个参数的组合
            try {
                method = ReflectionUtils.findMethod(springContextsController.getBean(beanName).getClass(), methodName,
                        CommonObjParam.class);
            } catch (Exception e) {
                // 反射错误，一般是没有对应的controll，或者controller没有注解命名
                logger.error(e);
                e.printStackTrace();
                return AjaxHelper.newFaildForSystemError();
            }
        }

        if (method == null) {
            // 没有找到对应的方法，一般是方法名称写错或者方法的参数未按照标准参数书写
            return AjaxHelper.newFaildForSystemError();
        }

        try {
            switch (method.getParameterTypes().length) {
                case 1:
                    return (CommonObjReturn) ReflectionUtils.invokeMethod(method,
                            springContextsController.getBean(beanName), objparam);
                case 2:
                    return (CommonObjReturn) ReflectionUtils.invokeMethod(method,
                            springContextsController.getBean(beanName), objparam, request);
                case 3:
                    return (CommonObjReturn) ReflectionUtils.invokeMethod(method,
                            springContextsController.getBean(beanName), objparam, request, response);
                default:
                    // 请求的方法，参数书写错误，属于编码规范未遵循
                    return AjaxHelper.newFaildForSystemError();
            }

        } catch (Exception e) {
            // 转交到业务模块后，业务模块处理出错且没有被业务模块自身catch住
            logger.error(e);
            e.printStackTrace();
            return AjaxHelper.newFaildForSystemError();
        }
    }

}
