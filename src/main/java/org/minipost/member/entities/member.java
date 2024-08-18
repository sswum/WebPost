package org.minipost.member.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Data
@Entity
public class member {

    private Long seq;
    private String email;
    private String password;


}
