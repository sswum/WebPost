package org.minipost.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.minipost.global.entities.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Board extends BaseEntity {

    @Id @GeneratedValue
    private Long seq;

    @Column(length = 50,nullable= false)
    private String title;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    @Lob
    private String content;
}
