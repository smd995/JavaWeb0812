package org.zerock.jdbcex.domain;

import lombok.*;
import org.zerock.jdbcex.dto.TodoDTO;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }
}
