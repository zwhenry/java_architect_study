package com.zhangwei.delegate.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 6:24 PM
 * @since 1.0.0
 **/
public class Leader implements  ITarget{

    private Map<String,ITarget> targets = new HashMap<String,ITarget>();

    public Leader() {
        targets.put("加密",new TargetA());
        targets.put("登录",new TargetB());
    }

    //项目经理自己不干活
    public void doing(String command){
        targets.get(command).doing(command);
    }

}
