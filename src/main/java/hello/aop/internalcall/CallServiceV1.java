package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    /**
     * 스프링부트 2.6부터 순환 참조를 기본적으로 막아놓도록 변경돼서 이 방법은 이제 X
     * 아니면 application.properties에 spring.main.allow-circular-references=true 추가
     */
    private CallServiceV1 callServiceV1;

    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal();   //외부 메서드 추가
    }

    public void internal() {
        log.info("call internal");
    }
}
