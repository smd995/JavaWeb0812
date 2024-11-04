package org.zerock.w2.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
@WebListener
public class W2AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(".................. init ..................");
        log.info(".................. init ..................");
        log.info(".................. init ..................");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("............... destroy ..............");
        log.info("............... destroy ..............");
        log.info("............... destroy ..............");
    }

}
