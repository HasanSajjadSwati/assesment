/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hasan
 */
@Data
@NoArgsConstructor
public class Email {
    private String email;
    private String subject;
    private String content;
    
}
