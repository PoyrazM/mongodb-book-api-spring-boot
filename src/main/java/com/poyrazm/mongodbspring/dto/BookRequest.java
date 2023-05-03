package com.poyrazm.mongodbspring.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    private String name;
    private String description;
    private String authorName;

}
