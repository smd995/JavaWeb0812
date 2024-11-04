package org.zerock.dao;

import lombok.Cleanup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;
    private TodoVO todoVO;
    @BeforeEach
    public void readyDAO() {
        todoDAO = new TodoDAO();
    }
    @BeforeEach
    public void readyVO() {
        todoVO = TodoVO.builder()
                .title("todo title")
                .dueDate(LocalDate.of(2021,12,31))
                .finished(false)
                .build();
    }
    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        todoDAO.insert(todoVO);
        System.out.println("테스트 성공~");
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 2L;
        todoVO  = todoDAO.selectOne(tno);
        System.out.println(todoVO);
    }

    @Test
    public void testDelete() throws Exception {
        todoDAO.delete(1L);
    }

    @Test
    public void testUpdate() throws Exception {
        todoVO = TodoVO.builder()
                .tno(1L)
                .title("update title ...")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        todoDAO.update(todoVO);
    }
}
