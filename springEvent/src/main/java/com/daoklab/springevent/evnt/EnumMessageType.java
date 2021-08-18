package com.daoklab.springevent.evnt;

/**
 * @Project: test
 * @Pacakge: com.daoklab.springevent
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 13:08 2021/7/24
 */
public enum EnumMessageType {

    NORMAL("normal", 0, "一般消息"),
    DENGERE("dengere", 1, "紧急消息");

    private String name;
    private Integer value;
    private String desc;

    EnumMessageType(String name, Integer value, String desc) {
        this.name = name;
        this.value = value;
        this.desc = desc;
    }

    public static EnumMessageType getByValue(Integer value) {
        for (EnumMessageType e : values()) {
            return e;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
