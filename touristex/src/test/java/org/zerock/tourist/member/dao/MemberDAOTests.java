package org.zerock.tourist.member.dao;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.tourist.member.domain.MemberVO;

public class MemberDAOTests {

    private MemberDAO dao;

    @BeforeEach
    public void ready() {
        dao = new MemberDAO();
    }

    @Test
    public void testTime() throws Exception {

        System.out.println(dao.getTime());
    }

    @Test
    public void insertTest() throws Exception {
        MemberVO vo = MemberVO.builder()
                .email1("abcd")
                .email2("naver.com")
                .memberId("abcd")
                .name("김길수")
                .memberPw("1234")
                .phone("01012341234")
                .gender("m")
                .agree(true)
                .build();

        dao.insert(vo);
    }
//
//    @Test
//    public void testList() throws Exception {
//        List<TodoVO> list = todoDAO.selectAll();
//
//        list.forEach(vo -> System.out.println(vo));
//    }
//
//    @Test
//    public void testSelectOne() throws Exception {
//        Long tno = 1L;
//        TodoVO todoVO = todoDAO.selectOne(tno);
//
//        System.out.println(todoVO);
//
//    }
//
//    @Test
//    public void deleteOne() throws Exception{
//        Long tno = 2L;
//        todoDAO.deleteOne(tno);
//
//    }
//
//    @Test
//    public void updateOne() throws Exception{
//        TodoVO vo = TodoVO.builder()
//                .tno(2L)
//                .title("sample title2")
//                .dueDate(LocalDate.of(2025,1,31))
//                .writer("sample writer2")
//                .done(true)
//                .build();
//
//        todoDAO.updateOne(vo);
//    }
}
