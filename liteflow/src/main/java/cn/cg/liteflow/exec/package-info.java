/**
 * 执行器
 * https://liteflow.yomahub.com/pages/20072e/#%E8%BF%94%E5%9B%9E%E7%B1%BB%E5%9E%8B%E4%B8%BAliteflowresponse
 * <p>
 * //参数为流程ID，无初始流程入参，上下文类型为默认的DefaultContext
 * public LiteflowResponse execute2Resp(String chainId)
 * //第一个参数为流程ID，第二个参数为流程入参。上下文类型为默认的DefaultContext
 * public LiteflowResponse execute2Resp(String chainId, Object param);
 * //第一个参数为流程ID，第二个参数为流程入参，后面可以传入多个上下文class
 * public LiteflowResponse execute2Resp(String chainId, Object param, Class<?>... contextBeanClazzArray)
 * //第一个参数为流程ID，第二个参数为流程入参，后面可以传入多个上下文的Bean
 * public LiteflowResponse execute2Resp(String chainId, Object param, Object... contextBeanArray)
 *
 * @author: cg
 * @date: 2023-08-01 17:41
 **/
package cn.cg.liteflow.exec;
