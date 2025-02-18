package com.gustavofosu.responseentitydemo.model;

/*
    Created by Gustav on 2/18/2025
    @author : Gustav Ofosu
    @date : 2/18/2025
    @project : response-entity-demo
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}
