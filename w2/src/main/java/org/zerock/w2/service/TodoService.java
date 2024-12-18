package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;
    private TodoDAO dao;
    private ModelMapper modelMapper;
    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

        // 수동 매핑 추가
        modelMapper.typeMap(TodoDTO.class, TodoVO.class).addMappings(mapper -> {
            mapper.map(TodoDTO::getTitle, TodoVO::setTitle);
            mapper.map(TodoDTO::getDueDate, TodoVO::setDueDate);
        });
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList............");
        log.info(voList);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    public TodoDTO getOne(Long tno) throws Exception {
        TodoVO todoVO = dao.selectOne(tno);

        TodoDTO dto = modelMapper.map(todoVO, TodoDTO.class);

        return dto;
    }

    public void modify (TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        dao.update(todoVO);
    }

    public void remove(Long tno) throws Exception {
        dao.delete(tno);
    }
}
