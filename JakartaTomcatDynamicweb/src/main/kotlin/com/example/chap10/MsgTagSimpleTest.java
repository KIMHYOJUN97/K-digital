package com.example.chap10;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MsgTagSimpleTest extends SimpleTagSupport {

    @Override
    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        out.println("커스텀 태그 출력 메시지: Hello World!");
    }
}
