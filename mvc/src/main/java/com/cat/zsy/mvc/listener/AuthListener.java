package com.cat.zsy.mvc.listener;

import com.cat.zsy.mvc.domain.Manager;
import com.cat.zsy.mvc.repository.ManagerRepository;
import com.cat.zsy.mvc.utils.PhpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

@Slf4j
public class AuthListener implements ServletContextListener {

    private static final Map<Manager, List<Long>> map = new HashMap<>(1 << 8);
    private ManagerRepository managerRepository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        if (applicationContext == null) {
            logger.error("----------spring加载出错----------");
            return;
        }

        this.managerRepository = applicationContext.getBean(ManagerRepository.class);
        logger.info("----------加载admin信息----------");
        List<Manager> managers = managerRepository.findAll();

        managers.forEach(manager -> {
            if (manager.getType() != 0) {
                List<Long> stores = PhpUtils.parse(manager.getStores());
                map.put(manager, stores);
            }
        });

        logger.info("----------加载admin完毕----------");
        map.forEach((m, s) -> {
            logger.info("{} 拥有权限 {}", m.getName(), m.getType() == 0 ? "管理员" : StringUtils.collectionToDelimitedString(s, ","));
        });
    }
}
