package cn.bclearn.callchain.core.around;

import cn.bclearn.callchain.core.point.BuriedPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AroundMethod {
    private static Logger logger = LoggerFactory.getLogger(AroundMethod.class);

    public static void playBeforeMethod(ProceedingJoinPoint pjp, int identify) {
        logger.debug("AroundMethodBefore "+pjp.getSignature().getDeclaringTypeName()+" "+pjp.getSignature().getName());
        BuriedPoint.before(pjp,identify);
    }

    public static void playAfterMethod(ProceedingJoinPoint pjp, int identify, Object obj) {
        logger.debug("AroundMethodAfter "+pjp.getSignature().getDeclaringTypeName()+" "+pjp.getSignature().getName());
        BuriedPoint.after(identify,obj!=null?obj.getClass().getName():null);
    }

}