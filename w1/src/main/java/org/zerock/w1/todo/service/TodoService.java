package org.zerock.w1.todo.service;

import org.zerock.w1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG........." + todoDTO);
    }

    public List<TodoDTO> getList() {
        // list의 데이터를 직접 작성
        // IntStream.range(0,10) : 10번 반복
        // mapToObj(i -> {실행코드});
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo"+i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList()); // 반환값의 타입을 List타입으로 설정
        return todoDTOS;
    }

    public TodoDTO get(long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Todo"+tno);
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }
}
