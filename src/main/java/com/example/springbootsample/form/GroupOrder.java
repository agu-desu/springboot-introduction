package com.example.springbootsample.form;

import jakarta.validation.GroupSequence;
// @GroupSequenceは、バリデーションの順番を設定する。左から順番にバリデーションをかけていく。
@GroupSequence({ ValidGroup1.class, ValidGroup2.class})
public interface GroupOrder {// interfaceであることに注意！　
    
}
