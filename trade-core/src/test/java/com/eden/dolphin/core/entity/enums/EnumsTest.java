package com.eden.dolphin.core.entity.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumsTest {

    @Test
    public void testOrderType(){
        System.out.println(Direction.LONG);
        String aa = Direction.LONG.toString();
        System.out.println(aa);
        String bb = Direction.LONG.getMeaning();
        System.out.println(bb);
    }
}
