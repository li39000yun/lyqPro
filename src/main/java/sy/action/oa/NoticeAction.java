package sy.action.oa;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import sy.action.BaseAction;
import sy.model.oa.Notice;
import sy.service.oa.NoticeServiceI;

/**
 * 公告
 * Created by liyunqiang on 2016/7/17.
 */
@Namespace("/oa/notice")
@Action
public class NoticeAction extends BaseAction<Notice> {

    /**
     * 注入业务逻辑，使当前action调用service.xxx的时候，直接是调用基础业务逻辑
     * <p>
     * 如果想调用自己特有的服务方法时，请使用((TServiceI) service).methodName()这种形式强转类型调用
     *
     * @param service
     */
    @Autowired
    public void setService(NoticeServiceI service) {
        this.service = service;
    }
}
