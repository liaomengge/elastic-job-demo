
package com.sh.lmg.main;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringJobMainWthNamespace {

    private SpringJobMainWthNamespace() {
    }

    public static void main(final String[] args) {
        new ClassPathXmlApplicationContext("classpath:META-INF/withNamespace.xml");
    }
}
