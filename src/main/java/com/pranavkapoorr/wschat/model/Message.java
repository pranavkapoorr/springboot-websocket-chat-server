package com.pranavkapoorr.wschat.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String from;
    private String text;
}