
package com.sh.lmg.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringJobMainWthNamespaceAndListener {

    private SpringJobMainWthNamespaceAndListener() {
    }

    public static void main(final String[] args) {
        new ClassPathXmlApplicationContext("classpath:META-INF/withNamespaceAndListener.xml");
    }
}
