package com.daoklab.springevent.evnt;

/**
 * @Project: test
 * @Pacakge: com.daoklab.springevent
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 12:58 2021/7/24
 */
public class MessageActionEvent extends ApplicationEvent{

    /**
     * 消息类型
     */
    private EnumMessageType operate;

    /**
     * 消息内容
     */
    private MessageBody messageBody;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MessageActionEvent(Object source) {
        super(source);
    }

    public EnumMessageType getOperate() {
        return operate;
    }

    public void setOperate(EnumMessageType operate) {
        this.operate = operate;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }
}
