package com.example.demo.controller.attribute;

import com.example.demo.controller.test.TestController;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;

@Log
@Controller
public class AttributeTestController {

    // 1. 일단 동작하는 코드를 작성합니다.
    // 2. 동작하는 코드 작성 이후에 코드에 대한 설명을 진행합니다.
    // 3. 설명 이후에 추가적인 질의 응답을 받습니다.

    // 1번째: 프로젝트 퀄리티를 조금 낮추고 코드 작성과 설명을 병행합니다.(가장 기초)
    // 2번째: 스프링 기능을 좀 더 다양하게 사용해보고 기존 방식으로 진행합니다.
    //       (Vue, JPA, JWT)
    @GetMapping("/attributeTest")
    public String getAttributeTest(Model model) {
        log.info("getAttributeTest(): Spring Attribute Test");

        Date date = new Date();
        // getDateTimeInstance()는 현재 우리가 사는 곳을 기준으로한 포맷을 가지고 일자/시각 형태의 포맷을 가져옵니다.
        // 2021년 3월 3일 (수) 오후 4시 55분 52초: 년월일(일자)/시각 형태
        // 인자로 셋팅되는 LONG, LONG은 항상 변함 없이 동일한데
        // 일자에 대한 정보, 시간에 대한 정보
        // 특정한 일자와 날자를 표현하고자 하는 경우 언제나 아래 코드를 동일하게 사용할 수 있다.
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        // 일자/시각 형태의 포맷에 현재 date(날자)를 입력하니
        // 해당 일자와 시각에 대한 정보가 문자열 형태로 만들어진다.
        String formattedDate = dateFormat.format(date);
        // Spring 상에서 사용하는 모든 데이터를 Model이 관리할 수 있다.
        // HTML과 Spring의 데이터를 제어할 수 있는 Model 객체에 속성값으로 등록하는 작업이다.
        // 이 Model에 속성값 responseServerTime을 만들고
        // 해당 속성은 위의 일자/시각 형태를 저장하고 있게 만드는 코드에 해당한다.
        
        // 만약 SimpleDateFormat을 사용해야 한다면 
        // SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        // sdf.format(~~~) -> String
        // 결국 SimpleDateFormat의 경우엔 특정한 형식을 지정하기가 좀 더 수월하다는 이점이 있음
        model.addAttribute("responseServerTime", formattedDate);

        return "attribute/test";
    }
}
